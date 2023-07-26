package ru.hogwarts.demo.school.h.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.demo.school.h.model.Avatar;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.repository.AvatarRepository;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class AvatarService {
    public final AvatarService avatarService;{
    }
    public AvatarService(AvatarService avatarService) {
        this.avatarService = avatarService;
    }
}
