package com.example.DemoFullCalendar.processor;

import com.example.DemoFullCalendar.enums.CalendarJsonKeywords;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileProcessor {

    public String addCalendarEvent(String jsonEntry, String calendarData) {
        // Specify the path to the JSON file
        final String FILEPATH = "src/main/resources/calendar.json";
        // Parse the JSON string into a JSON array
        JSONArray jsonArray = new JSONArray(calendarData);
        try {
            // Create a new entry as a JSON object
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            JsonObject jsonObject = gson.fromJson(jsonEntry, JsonObject.class);
            // Add the new entry to the JSON array
            JSONObject newEntry = new JSONObject();

            newEntry.put(CalendarJsonKeywords.Title.value,
                    jsonObject.get(CalendarJsonKeywords.Title.value).getAsString());
            newEntry.put(CalendarJsonKeywords.Start.value,
                    jsonObject.get(CalendarJsonKeywords.Start.value).getAsString());
            newEntry.put(CalendarJsonKeywords.End.value,
                    jsonObject.get(CalendarJsonKeywords.End.value).getAsString());

            jsonArray.put(newEntry);
            // Write the modified JSON data back to the file
            Files.write(Paths.get(FILEPATH), jsonArray.toString().getBytes());


            System.out.println("Entry added successfully!");

        } catch (IOException |JSONException e) {
            e.printStackTrace();
            return calendarData;
        }
        return jsonArray.toString();
    }
}
