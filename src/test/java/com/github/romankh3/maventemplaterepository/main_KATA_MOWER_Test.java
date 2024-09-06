package com.github.romankh3.maventemplaterepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.romankh3.maventemplaterepository.Entity.Lawn;
import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.Utils.InputParser;
import com.github.romankh3.maventemplaterepository.commandProcessor.CommandProcessor;

/**
 * Unit-level testing for {@link MavenTemplateRepository} object.
 */
public class main_KATA_MOWER_Test {

    @Test
    public void shouldCreateJavaRepositoryTemplateMain() {
        KataMower main = new KataMower();
        Assertions.assertNotNull(main);
    }

    @Test
    public void testMainMethod() throws Exception {
        // Simuler la sortie standard
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Créer un fichier temporaire inputs.txt avec le contenu de test
        List<String> inputLines = List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        Files.write(Paths.get("inputs.txt"), inputLines);
        
        // Appeler la méthode main
        String[] args = {};
        KataMower.main(args);
        
        // Vérifier que la sortie contient les positions finales attendues
        String output = outContent.toString().trim();
        assertTrue(output.contains("1 3 N"));
        assertTrue(output.contains("5 1 E"));

        // Restaurer la sortie standard
        System.setOut(originalOut);

        // Supprimer le fichier temporaire après le test
        Files.deleteIfExists(Paths.get("inputs.txt"));
    }

}
