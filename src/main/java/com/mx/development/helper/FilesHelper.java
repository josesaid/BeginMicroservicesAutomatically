package com.mx.development.helper;

import com.mx.development.business.Directory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FilesHelper {

    public static void process(String rootPath) throws IOException {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("ROOT PATH : " + rootPath);
        System.out.println("--------------------------------------------------------------------------------");
        Optional<List<File>> directories = new Directory().verifyArgument(rootPath);
        if(directories.isPresent()) {
            System.out.println("Heart file exists? "  + createInitialFile(rootPath));
            Map<File, Boolean> microservicesMap = new HashMap<>();
            for(File microserviceDirectory :  directories.get()) {
                microservicesMap.put(microserviceDirectory, Directory.containsPOMFile(microserviceDirectory.getAbsolutePath()));
            }
            new MavenHelper().processMicroservices(microservicesMap);
        }
    }

    public static boolean createInitialFile(String rootPath) throws IOException {
        return new File(rootPath+"/"+"_apps_and_ports.said").createNewFile();
    }
}
