package com.javaED.config;

import com.javaED.model.Chapter;
import com.javaED.model.Section;
import com.javaED.repository.ChapterRepository;
import com.javaED.repository.SectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ChapterConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            ChapterRepository chapterRepository, SectionRepository sectionRepository) {
        return args -> {
            Chapter chapter1 = new Chapter(
                    "Chapter One",
                    true
            );

            Chapter chapter2 = new Chapter(
                    "Chapter Two",
                    false
            );

            Section section1 = new Section(
                    "1st Section",
                    "This is my first Section",
                    chapter1
            );

            Section section2 = new Section(
                    "2nd Section",
                    "This is my Second Section",
                    chapter1
            );

            Section section3 = new Section(
                    "3rd Section",
                    "This is my Third Section",
                    chapter2
            );

            chapterRepository.saveAll(
                    List.of(chapter1, chapter2)
            );

            sectionRepository.saveAll(
                    List.of(section1, section2, section3)
            );
        };
    }
}
