package org.os.commands;

import org.os.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveCommand implements Command{
    @Override
    public void execute(String[] args){
        if (args.length == 0) {
            System.out.println("Error: No file name provided.");
            return;
        }
        String fileName = args[0];
        Path filePath = Paths.get(Main.currentDirectory, fileName);

        try {
            if (Files.exists(filePath)) {
                Files.deleteIfExists(filePath);
                System.out.println("File removed successfully!");

            } else{
                System.out.println("This file does not exist!");
            }
        } catch (IOException e) {
            System.out.println("Error removing file: " + e.getMessage());
        }
    }
}
