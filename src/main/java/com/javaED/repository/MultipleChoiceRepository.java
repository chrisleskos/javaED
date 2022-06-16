package com.javaED.repository;

import com.javaED.model.question.MultipleChoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleChoiceRepository
        extends JpaRepository<MultipleChoice, Integer> {
}
