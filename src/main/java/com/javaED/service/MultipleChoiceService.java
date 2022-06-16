package com.javaED.service;

import com.javaED.model.question.MultipleChoice;
import com.javaED.repository.MultipleChoiceRepository;
import com.javaED.repository.TrueOrFalseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultipleChoiceService {

    MultipleChoiceRepository multipleChoiceRepository;

    @Autowired
    public MultipleChoiceService(MultipleChoiceRepository multipleChoiceRepository) {
        this.multipleChoiceRepository = multipleChoiceRepository;
    }

    public List<MultipleChoice> getQuestions() {
        return multipleChoiceRepository.findAll();
    }
}
