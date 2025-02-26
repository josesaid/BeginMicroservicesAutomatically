package com.mx.development.adapters;

import com.mx.development.Maven;
import com.mx.development.exceptions.MavenCompilationException;

import java.io.IOException;
import java.nio.file.Path;


public abstract class MavenSpringBootExecutorAdapter implements Maven {

    public void executeSpringBootApp(Path projectFolder, String command) {
        String microserviceName = projectFolder.getFileName().toString();
        int exitCode;
        try {
            exitCode = execute(projectFolder, command);
        } catch (InterruptedException e) {
            throw new MavenCompilationException("Interrupted during compilation", e);
        } catch (IOException e) {
            throw new MavenCompilationException("Incorrect execution", e);
        }
        if (exitCode != OK) {
            throw new MavenCompilationException("Failure during compilation: " + exitCode);
        }
        System.out.println("MicroserviceName: <" + microserviceName + "> status code: " + exitCode);
    }

    protected abstract int execute(Path projectFolder, String command)
            throws InterruptedException, IOException;
}
