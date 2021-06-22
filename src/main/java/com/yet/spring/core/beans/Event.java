package com.yet.spring.core.beans;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    public static boolean isDay(int start, int end) {
        LocalTime time = LocalTime.now();
        return time.getHour() > start && time.getHour() < end;
    }


    private int id = new Random().nextInt(100) + 1;
    private String msg;
    private Date date;

    private final DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.id = AUTO_ID.getAndIncrement();

        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", msg=" + msg + ", date=" + dateFormat.format(date) + "]";
    }
}
