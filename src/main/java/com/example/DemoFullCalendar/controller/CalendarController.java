package com.example.DemoFullCalendar.controller;

import com.example.DemoFullCalendar.processor.JsonFileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class CalendarController {

    private Boolean isFirstReload= Boolean.TRUE;
    private String calendarData = "";
    private final JsonFileProcessor jsonFileProcessor;

    @Autowired
    public CalendarController(JsonFileProcessor jsonFileProcessor){
        this.jsonFileProcessor = jsonFileProcessor;
    }


    @CrossOrigin
    @GetMapping(value = "/getCalendar", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCalendar() throws IOException {
        if(isFirstReload){
            isFirstReload = !isFirstReload;
            // Load the JSON file from the resources folder
            ClassPathResource resource = new ClassPathResource("calendar.json");
            byte[] fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
            calendarData = new String(fileData, StandardCharsets.UTF_8);
        }
        // Return the JSON content as a string
        return calendarData;
    }


    @CrossOrigin
    @PostMapping("/saveCalendar")
    public String saveCalendar(@RequestBody String jsonEntry) {
        calendarData = jsonFileProcessor.addCalendarEvent(jsonEntry, calendarData);
        return "Entry saved successfully.";
    }

}
