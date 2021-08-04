package com.example.eventfragmentcommunication.Model;

import java.io.Serializable;

public class EventModel implements Serializable {
    private String EventTitle;
    private String EvenDesc;
    private String EventStartDate;
    private String EventEndDate;
    private String EventStartTime;
    private String EventEndTime;
    private String Price;

    public EventModel(String eventTitle, String evenDesc, String eventStartDate, String eventEndDate, String eventStartTime, String eventEndTime, String price) {
        EventTitle = eventTitle;
        EvenDesc = evenDesc;
        EventStartDate = eventStartDate;
        EventEndDate = eventEndDate;
        EventStartTime = eventStartTime;
        EventEndTime = eventEndTime;
        Price = price;
    }

    public String getEventTitle() {
        return EventTitle;
    }

    public String getEvenDesc() {
        return EvenDesc;
    }

    public String getEventStartDate() {
        return EventStartDate;
    }

    public String getEventEndDate() {
        return EventEndDate;
    }

    public String getEventStartTime() {
        return EventStartTime;
    }

    public String getEventEndTime() {
        return EventEndTime;
    }

    public String getPrice() {
        return Price;
    }
}
