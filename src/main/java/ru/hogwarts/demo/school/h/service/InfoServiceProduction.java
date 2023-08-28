package ru.hogwarts.demo.school.h.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("admin")
public class InfoServiceProduction implements InfoService{
    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getPort() {
        return serverPort;
    }
}
