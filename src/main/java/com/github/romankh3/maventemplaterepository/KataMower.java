package com.github.romankh3.maventemplaterepository;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.github.romankh3.maventemplaterepository.Entity.Lawn;
import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.Utils.InputParser;
import com.github.romankh3.maventemplaterepository.commandProcessor.CommandProcessor;

/**
 * The KataMower class is the entry point for the Java application.
 * It reads input data from a resource file, parses it to create lawn and mower objects,
 * processes commands for each mower, and prints the final positions and orientations of the mowers.
 */
public class KataMower {
    
    /**
     * The main method is the entry point of the application.
     * It performs the following steps:
     * 1. Loads the input file from the classpath.
     * 2. Creates a temporary file and copies the content of the input file into it.
     * 3. Reads the content of the temporary file.
     * 4. Parses the content to create Lawn and Mower objects and extract commands.
     * 5. Processes each mower's commands and prints their final positions and orientations.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try{

            // Charger le fichier à partir du classpath
            InputStream inputStream = KataMower.class.getClassLoader().getResourceAsStream("inputs.txt");
            // Créer un fichier temporaire à partir du flux d'entrée
            Path tempFile = Files.createTempFile("inputs", ".txt");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            
            // Lire le contenu du fichier
            List<String> lines = Files.readAllLines(tempFile);

            InputParser parser = new InputParser();
            Lawn lawn = parser.parseLawn(lines.get(0).split(" "));
            List<Mower> mowers = parser.parseMowers(lines.subList(1, lines.size()), lawn);
            List<String> commands = parser.parseCommands(lines.subList(1, lines.size()));
    
            CommandProcessor processor = new CommandProcessor();
    
            for (int i = 0; i < mowers.size(); i++) {
                processor.processCmds(mowers.get(i), commands.get(i));
            }
        }catch(Exception e){
            System.out.println("file not found");
        }
    }
}
