package ru.hogwarts.demo.school.h.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.demo.school.h.model.Avatar;
import ru.hogwarts.demo.school.h.repository.AvatarRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class AvatarService {
    public final AvatarRepository avatarRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public static List<Avatar> getAllAvatar() {

        return getAllAvatar();
    }


    public Avatar addAvatar(Avatar avatar) {
        logger.info("Was invoked method for add avatar");
        return avatarRepository.save(avatar);
    }

    public Avatar findAvatar(long id) {
        logger.info("Was invoked method for find avatar");
        return avatarRepository.findById(id).get();
    }

    public Avatar editAvatar(Avatar avatar) {
        logger.info("Was invoked method for edit avatar");
        return avatarRepository.save(avatar);
    }

    public void deleteAvatar(long id) {
        logger.info("Was invoked method for delete avatar");
        avatarRepository.deleteById(id);
    }


    public List<Avatar> getAllAvatar(Integer pageSize, Integer pageNumber){
        logger.info("Was invoked method for get all avatars");
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return avatarRepository.findAll(pageRequest).getContent();
    }
}
