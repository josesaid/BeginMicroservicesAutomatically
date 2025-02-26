package com.mx.development.executors;

import com.mx.development.adapters.MavenSpringBootExecutorAdapter;
import com.mx.development.adapters.MavenStepExecutorAdapter;

import java.io.IOException;
import java.nio.file.Path;

public class MavenRuntimeSpringBootAppExec extends MavenSpringBootExecutorAdapter {
    @Override
    public int execute(Path projectFolder, String command) throws IOException, InterruptedException {
        String[] arguments = {MVN, USE_CUSTOM_POM, projectFolder.resolve(POM_XML).toString(), command};
        Process process = Runtime.getRuntime().exec(arguments);
        return 0;
    }

}