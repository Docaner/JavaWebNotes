package ru.csomod.notes.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:notes.properties")
public class DataBaseSettings {
    @Value("${db.host}")
    private String host;
    @Value("${db.port}")
    private String port;
    @Value("${db.base}")
    private String db;
    @Value("${db.user}")
    private String user;
    @Value("${db.pass}")
    private String password;
    @Value("${db.table}")
    private String table;


    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getTable() {
        return table;
    }

}
