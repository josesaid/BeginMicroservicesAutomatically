package com.mx.development.executors;

import com.mx.development.adapters.MavenStepExecutorAdapter;
import java.io.IOException;
import java.nio.file.Path;

public class MavenRuntimeStepExec extends MavenStepExecutorAdapter {
    @Override
    public int execute(Path projectFolder, String stepGoal) throws IOException, InterruptedException {
        String[] arguments = new String[]{MVN, USE_CUSTOM_POM, projectFolder.resolve(POM_XML).toString(), stepGoal};
        Process process = Runtime.getRuntime().exec(arguments);
        return process.waitFor();
    }



}
