package com.javaED.service;

import com.javaED.model.account.AppUser;
import com.javaED.model.account.userProgress.Mistake;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;
import com.javaED.repository.MistakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MistakeService {
    private final MistakeRepository mistakeRepository;

    @Autowired
    public MistakeService(MistakeRepository mistakeRepository) {
        this.mistakeRepository = mistakeRepository;
    }

    public void saveMistake(Mistake mistake) {
        mistakeRepository.save(mistake);
    }

    public Optional<Mistake> getMistake(AppUser appUser, Section section){
        return mistakeRepository.findByAppUserAndQuestion(appUser, section);
    }

    public List<Mistake> getUserMistakes(AppUser appUser){
        return mistakeRepository.findByUser(appUser);
    }

    public void updateCount(Mistake mistake) {
        mistakeRepository.updateMistakeCount(mistake.getCount(), mistake.getId());
    }
}
