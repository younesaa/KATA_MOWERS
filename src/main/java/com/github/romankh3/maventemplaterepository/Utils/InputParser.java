package com.github.romankh3.maventemplaterepository.Utils;

import java.util.ArrayList;
import java.util.List;

import com.github.romankh3.maventemplaterepository.Entity.Lawn;
import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.Entity.Orientation;
import com.github.romankh3.maventemplaterepository.Entity.Position;

/**
 * The InputParser class is responsible for parsing input data to create instances of Lawn, Mower,
 * and extracting command sequences from the input data.
 */
public class InputParser {

    /**
     * Parses the first line of input to create a Lawn object with the specified dimensions.
     *
     * @param firstLine An array of strings representing the dimensions of the lawn.
     *                  The first element is the maximum x-coordinate and the second element is the maximum y-coordinate.
     * @return A Lawn object initialized with the provided dimensions.
     */
    public Lawn parseLawn(String[] firstLine) {
        int maxX = Integer.parseInt(firstLine[0]);
        int maxY = Integer.parseInt(firstLine[1]);
        return new Lawn(maxX, maxY);
    }

    /**
     * Parses a list of strings to create a list of Mower objects.
     * Each mower is initialized with a position and orientation from the provided lines and the given lawn.
     *
     * @param lines A list of strings where every two lines represent the position and orientation of a mower,
     *              followed by its command sequence.
     * @param lawn  The Lawn object representing the boundaries where mowers operate.
     * @return A list of Mower objects created from the provided lines.
     */    
    public List<Mower> parseMowers(List<String> lines, Lawn lawn) {
        List<Mower> mowers = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 2) {
            String[] positionAndOrientation = lines.get(i).split(" ");
            int x = Integer.parseInt(positionAndOrientation[0]);
            int y = Integer.parseInt(positionAndOrientation[1]);
            Orientation orientation = Orientation.valueOf(positionAndOrientation[2]);

            Position position = new Position(x, y);
            Mower mower = new Mower(position, orientation, lawn);
            mowers.add(mower);
        }
        return mowers;
    }

    /**
     * Parses a list of strings to extract command sequences for each mower.
     * The command sequences are extracted from the odd-indexed lines of the input.
     *
     * @param lines A list of strings where every second line starting from index 1 contains command sequences.
     * @return A list of command sequences as strings, corresponding to the mowers.
     */    
    public List<String> parseCommands(List<String> lines) {
        List<String> commands = new ArrayList<>();
        for (int i = 1; i < lines.size(); i += 2) {
            commands.add(lines.get(i));
        }
        return commands;
    }
}
