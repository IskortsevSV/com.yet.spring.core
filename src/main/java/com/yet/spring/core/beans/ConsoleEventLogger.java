package com.yet.spring.core.beans;

public class ConsoleEventLogger extends AbstractLogger {

    private String name;

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
