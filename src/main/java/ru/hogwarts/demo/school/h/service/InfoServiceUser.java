package ru.hogwarts.demo.school.h.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service

@Profile("user")
public class InfoServiceUser implements InfoService {
    @Value("${server.port}")
    private String port;

    @Override
    public String getPort() {
        return port;
    }
    }