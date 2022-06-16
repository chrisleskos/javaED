package com.javaED.repository;

import com.javaED.model.question.TrueOrFalse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrueOrFalseRepository
        extends JpaRepository<TrueOrFalse, Integer> {
}
