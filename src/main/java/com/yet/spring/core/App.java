package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventLogger;
import com.yet.spring.core.beans.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class App {

    private Client client;
    private Map<EventType, EventLogger> loggers;
    private EventLogger defaultLogger;

    private String startupMessage;



    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType type,Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);


    }

    public Map<EventType, EventLogger> getLoggers() {
        return loggers;
    }



    public static void main(String[] args) {
        // не содержит метод close()
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        System.out.println(app.startupMessage);

        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3");


        ctx.close();
    }

    public void setStartupMessage(String startupMessage) {
        this.startupMessage = startupMessage;
    }

    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }

}
