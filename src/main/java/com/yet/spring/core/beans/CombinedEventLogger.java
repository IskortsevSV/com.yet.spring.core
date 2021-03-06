package com.yet.spring.core.beans;

import java.util.Collection;
import java.util.Collections;

public class CombinedEventLogger extends AbstractLogger {

    private Collection<EventLogger> loggers;
    private String name;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(logger -> logger.logEvent(event));
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
