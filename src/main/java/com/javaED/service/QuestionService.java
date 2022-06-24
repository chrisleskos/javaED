package com.javaED.service;

import com.javaED.model.question.Question;
import com.javaED.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestion(int id) {
        return questionRepository.getReferenceById(id);
    }
}
