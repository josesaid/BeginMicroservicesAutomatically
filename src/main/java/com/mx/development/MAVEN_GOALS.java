package com.mx.development;

public enum MAVEN_GOALS {

    CLEAN("clean"),
    COMPILE("compile"),
    PACKAGE("package");

    private String goal;

    MAVEN_GOALS(String goal) {
        this.goal = goal;
    }

    public String getGoal() {
        return goal;
    }
}
