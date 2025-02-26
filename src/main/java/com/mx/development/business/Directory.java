package com.mx.development.business;

import java.io.File;

public class Directory {
    public static void verifyArgument(String possibleDirectory) {
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
    }
}
