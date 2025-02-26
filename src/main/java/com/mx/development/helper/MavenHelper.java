package com.mx.development.helper;

import com.mx.development.MavenRuntimeExec;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class MavenHelper {

    //Received all microservices and call clean and build maven mechanisms on them.
    public void processMicroservices(Map<File, Boolean> microservicesMap) {
        for (Map.Entry<File, Boolean> entry : microservicesMap.entrySet()) {
            if(entry.getValue()) {
                Path path = Paths.get(entry.getKey().getAbsolutePath());
                /*BaseResult baseResult = */new MavenRuntimeExec().executeStep(path, "clean");
                //System.out.println("Maven clean result: " + baseResult);
            }
        }
    }

}
