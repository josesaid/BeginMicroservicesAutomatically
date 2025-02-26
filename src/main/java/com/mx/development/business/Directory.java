package com.mx.development.business;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Directory {
    public static Optional<List<File>> verifyArgument(String possibleDirectory) {
        List<File> directories = new ArrayList<>();

        File directory = new File(possibleDirectory);
        if(!directory.exists()) {
            System.err.println("Directory does not exist: " + possibleDirectory);
            System.exit(1);
        }
        if(!directory.isDirectory()) {
            System.err.println("Directory is not a directory: " + possibleDirectory);
            System.exit(1);
        }
        if(!directory.canRead()) {
            System.err.println("Directory is not readable: " + possibleDirectory);
            System.exit(1);
        }

        File[] files = directory.listFiles();
        if(files == null) {
            System.err.println("Directory does not contain any files: " + possibleDirectory);
        }
        else {
            for(File file : files) {
                if(file.isDirectory()) {
                    System.out.println(file.getAbsolutePath());
                    directories.add(file);
                }
            }
            System.out.println();
            System.out.println("Found " + directories.size() + " directories to be processed.");
            System.out.println();
            return Optional.of(directories);
        }
        return Optional.empty();
    }

    public static boolean containsPOMFile(String path){
        return Arrays.stream(new File(path)
                .listFiles((dir, name) -> name.contains("pom.xml")))
                .count() > 0;
    }

}
