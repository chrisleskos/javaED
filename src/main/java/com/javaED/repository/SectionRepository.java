package com.javaED.repository;

import com.javaED.model.material.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository
        extends JpaRepository<Section, Integer> {
}
