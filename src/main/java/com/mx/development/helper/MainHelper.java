package com.mx.development.helper;

import java.io.IOException;

public class MainHelper {

    public static void process(String []args) throws IOException {
        if(args.length == 0) {
            System.err.println("Usage: java -jar BeginMicroservicesAutomatically.jar someDirectoryWithMavenProjectNames");
            System.exit(1);
        }
        if(args.length == 1) {
            new FilesHelper().process(args[0]);
        }

        System.exit(0);
    }

}
