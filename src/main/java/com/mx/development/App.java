package com.mx.development;
import com.mx.development.helper.MainHelper;

/**
 * Main class used to start all the Microservice's architecture for a given directory
 *
 */
public class App {

    public static void main( String[] args ) {
        new MainHelper().process(args);
    }

}
