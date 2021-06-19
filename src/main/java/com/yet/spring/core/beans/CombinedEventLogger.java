package com.yet.spring.core.beans;

import java.util.Collection;
import com.yet.spring.core.beans.Event;

public class CombinedEventLogger implements EventLogger{

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(logger -> logger.logEvent(event));
    }

    @Override
    public String getName() {
        return null;
    }
}
