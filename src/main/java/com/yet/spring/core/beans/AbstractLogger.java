package com.yet.spring.core.beans;

public abstract class AbstractLogger implements EventLogger {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

}
