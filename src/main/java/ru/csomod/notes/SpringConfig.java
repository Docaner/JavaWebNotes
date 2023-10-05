package ru.csomod.notes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.csomod.notes")
@PropertySource("classpath:notes.properties")
public class SpringConfig {
    @Bean
    public Note noteBean(){
        return new Note();
    }
}
