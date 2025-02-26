package com.mx.development.helper;

import com.mx.development.executors.MavenRuntimeSpringBootAppExec;
import com.mx.development.executors.MavenRuntimeStepExec;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class MavenHelper {

    //Received all microservices and call clean and build maven mechanisms on them.
    public void processMicroservices(Map<File, Boolean> microservicesMap) {
        // execute clean and build steps
        executeCleanStep(microservicesMap);
        executeInstallStep(microservicesMap);
        System.out.println("--------------------------------------------------------------------------------");

        //start-up the microservices
        startMicroservices(microservicesMap);
    }

    private void startMicroservices(Map<File, Boolean> microservicesMap) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("START MICROSERVICES");
        for (Map.Entry<File, Boolean> entry : microservicesMap.entrySet()) {
            if (entry.getValue()) {
                System.out.println("MICROSERVICE: " + entry.getKey());
                Path path = Paths.get(entry.getKey().getAbsolutePath());
                new MavenRuntimeSpringBootAppExec().executeSpringBootApp(path, "spring-boot:run");
            }
        }
        System.out.println();
        System.out.println("All the microservices started successfully");
        System.out.println("--------------------------------------------------------------------------------");
    }

    private void executeCleanStep(Map<File, Boolean> microservicesMap) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("CLEAN MICROSERVICES");
        for (Map.Entry<File, Boolean> entry : microservicesMap.entrySet()) {
            if(entry.getValue()) {
                Path path = Paths.get(entry.getKey().getAbsolutePath());
                new MavenRuntimeStepExec().executeStep(path, "clean");
            }
        }
    }

    private void executeInstallStep(Map<File, Boolean> microservicesMap) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("INSTALL MICROSERVICES");
        for (Map.Entry<File, Boolean> entry : microservicesMap.entrySet()) {
            if(entry.getValue()) {
                Path path = Paths.get(entry.getKey().getAbsolutePath());
                new MavenRuntimeStepExec().executeStep(path, "install");
            }
        }
    }

}
