package com.example.DemoFullCalendar.enums;

public enum CalendarJsonKeywords {
    Title("title"),
    Start("start"),
    End("end");

    public final String value;

    private CalendarJsonKeywords(String value){
        this.value = value;
    }


}
