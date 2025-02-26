package com.mx.development;
import com.mx.development.business.Directory;

/**
 * Main class used to start all the Microservice's architecture for a given directory
 *
 */
public class App {
    public static void main( String[] args ) {
        if(args.length == 0) {
            System.err.println("Usage: java -jar BeginMicroservicesAutomatically.jar someDirectoryWithMavenProjectNames");
            System.exit(1);
        }
        if(args.length == 1) {
            System.out.println("Received argument: " + args[0]);
            new Directory().verifyArgument(args[0]);
        }
        System.exit(0);
    }

}
