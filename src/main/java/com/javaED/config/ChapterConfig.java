package com.javaED.config;

import com.javaED.model.account.AppUser;
import com.javaED.model.account.RegistrationRequest;
import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.MultipleChoice;
import com.javaED.model.question.Question;
import com.javaED.model.question.TrueOrFalse;
import com.javaED.repository.*;
import com.javaED.service.AppUserService;
import com.javaED.service.RegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChapterConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            ChapterRepository chapterRepository,
            SectionRepository sectionRepository,
            MultipleChoiceRepository multipleChoiceRepository,
            TrueOrFalseRepository trueOrFalseRepository,
            AppUserService appUserService,
            RegistrationService registrationService
    ) {
        return args -> {
            RegistrationRequest request = new RegistrationRequest(
                    "admin",
                    "admin@example.com",
                    "12345"
            );

            Chapter chapter1 = new Chapter(
                    "Variables",
                    true
            );

            Chapter chapter2 = new Chapter(
                    "Operators",
                    false
            );

            Section section1 = new Section(
                    "Variable Data Types",
                    "This is my first Section",
                    chapter1
            );

            Section section2 = new Section(
                    "Variable Declaration",
                    "This is my Second Section",
                    chapter1
            );

            Section section3 = new Section(
                    "Arithmetic Operators",
                    "This is my Third Section",
                    chapter2
            );

            Question q1 = new MultipleChoice(
                    "Why are we?",
                    "because",
                    "we",
                    "are",
                    section1
            );

            Question q2 = new MultipleChoice(
                    "To be or not to be?",
                    "because",
                    "it",
                    "is",
                    section1
            );

            Question q3 = new TrueOrFalse(
                    "A true or false question",
                    "True",
                    section1
            );

            Question q4 = new TrueOrFalse(
                    "A SECOND true or false question",
                    "False",
                    section1
            );

            Question q5 = new MultipleChoice(
                    "Omg fifth Multiple choice?",
                    "YES!",
                    "dk",
                    "dc",
                    section2
            );

            Question q6 = new MultipleChoice(
                    "An extra Multiple?",
                    "Maybe",
                    "enough",
                    "perfect",
                    section2
            );

            Question q7 = new TrueOrFalse(
                    "A THIRDD true or false question",
                    "False",
                    section1
            );

            Question q8 = new TrueOrFalse(
                    "LAST true or false question",
                    "True",
                    section2
            );

            registrationService.register(request);

            appUserService.enableAppUser("admin");

            chapterRepository.saveAll(
                    List.of(chapter1, chapter2)
            );

            sectionRepository.saveAll(
                    List.of(section1, section2, section3)
            );

            multipleChoiceRepository.saveAll(
                    List.of((MultipleChoice)q1, (MultipleChoice)q2, (MultipleChoice) q5, (MultipleChoice) q6)
            );

            trueOrFalseRepository.saveAll(
                    List.of((TrueOrFalse) q3, (TrueOrFalse)q4, (TrueOrFalse) q7, (TrueOrFalse) q8)
            );
        };
    }
}
