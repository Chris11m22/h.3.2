package ru.hogwarts.demo.school.h.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.demo.school.h.model.Avatar;
import ru.hogwarts.demo.school.h.repository.AvatarRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class AvatarService {
    public final AvatarRepository avatarRepository;

    {
    }

    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public static List<Avatar> getAllAvatar() {
        return getAllAvatar();
    }


    public Avatar addAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    public Avatar findAvatar(long id) {
        return avatarRepository.findById(id).get();
    }

    public Avatar editAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    public void deleteAvatar(long id) {
        avatarRepository.deleteById(id);
    }


    public List<Avatar> getAllAvatar(Integer pageSize, Integer pageNumber){
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return avatarRepository.findAll(pageRequest).getContent();
    }
}
