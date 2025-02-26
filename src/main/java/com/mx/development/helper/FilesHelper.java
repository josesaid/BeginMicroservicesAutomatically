package com.mx.development.helper;

import com.mx.development.business.Directory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FilesHelper {

    public static void process(String rootPath) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("ROOT PATH : " + rootPath);
        System.out.println("--------------------------------------------------------------------------------");
        Optional<List<File>> directories = new Directory().verifyArgument(rootPath);
        if(directories.isPresent()) {
            Map<File, Boolean> microservicesMap = new HashMap<>();
            for(File microserviceDirectory :  directories.get()) {
                microservicesMap.put(microserviceDirectory, Directory.containsPOMFile(microserviceDirectory.getAbsolutePath()));
            }
            new MavenHelper().processMicroservices(microservicesMap);
        }
    }

}
