package com.javaED.service;

import com.javaED.model.account.AppUser;
import com.javaED.model.account.userProgress.Mistake;
import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.test.Test;
import com.javaED.repository.MistakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    public Optional<Mistake> getMistake(AppUser appUser, Question question){
        return mistakeRepository.findByUserAndQuestion(appUser, question);
    }

    public List<Mistake> getUserMistakes(AppUser appUser){
        return mistakeRepository.findByUser(appUser);
    }

    public void increaseCount(Mistake mistake) {
        mistakeRepository.updateCount(mistake);
    }
}
