package com.javaED.service;

import com.javaED.model.question.TrueOrFalse;
import com.javaED.repository.MultipleChoiceRepository;
import com.javaED.repository.TrueOrFalseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrueOrFalseService {
    TrueOrFalseRepository trueOrFalseRepository;

    @Autowired
    public TrueOrFalseService(TrueOrFalseRepository trueOrFalseRepository) {
        this.trueOrFalseRepository = trueOrFalseRepository;
    }

    public List<TrueOrFalse> getQuestions() {
        return trueOrFalseRepository.findAll();
    }
}
