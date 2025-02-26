package com.mx.development;

import com.mx.development.helper.MavenExecutorAdapter;
import java.io.IOException;
import java.nio.file.Path;

public class MavenRuntimeExec extends MavenExecutorAdapter {
    @Override
    public int execute(Path projectFolder, String stepGoal) throws IOException, InterruptedException {
        String[] arguments = {MVN, USE_CUSTOM_POM, projectFolder.resolve(POM_XML).toString(), stepGoal};
        Process process = Runtime.getRuntime().exec(arguments);
        return process.waitFor();
    }



}
