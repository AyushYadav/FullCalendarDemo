package com.example.DemoFullCalendar;

import com.example.DemoFullCalendar.processor.JsonFileProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JsonFileProcessor jsonFileProcessor(){
        return new JsonFileProcessor();
    }
}
