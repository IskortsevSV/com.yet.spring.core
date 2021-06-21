package com.yet.spring.core.beans;

public class ConsoleEventLogger extends AbstractLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

    @Override
    public String getName() {
        return null;
    }
}
