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
                    "Variables"
            );

            Chapter chapter2 = new Chapter(
                    "Operators"
            );

            Section section1 = new Section(
                    "Data Types",
                    "data-types",
                    chapter1
            );

            Section section2 = new Section(
                    "Declaration",
                    "declaration",
                    chapter1
            );

            Section section3 = new Section(
                    "Arithmetic Operators",
                    "section1",
                    chapter2
            );

            Section section4 = new Section(
                    "Comparison Operators",
                    "section1",
                    chapter2
            );

            Section section5 = new Section(
                    "Logical Operators",
                    "section1",
                    chapter2
            );

            Question q1 = new MultipleChoice(
                    "Which of these is a type of int?",
                    "25",
                    "0.32",
                    "'b'",
                    section1
            );

            Question q2 = new MultipleChoice(
                    "The variable 'myVar' holds the value 'true'. Its data type is:",
                    "boolean",
                    "float",
                    "String",
                    section1
            );

            Question q3 = new TrueOrFalse(
                    "A variable of type char is declared with single quotes",
                    "True",
                    section1
            );

            Question q4 = new TrueOrFalse(
                    "A variable of type int cannot be negative.",
                    "False",
                    section1
            );

            Question q7 = new TrueOrFalse(
                    "The value \"John\" is of type String",
                    "True",
                    section1
            );

            Question q5 = new MultipleChoice(
                    "Which of the choices has a right syntax?",
                    "int myNum = 15;",
                    "int 15 = myNum;",
                    "myNum int = 15;",
                    section2
            );

            Question q6 = new MultipleChoice(
                    "Values to variables are a signed with the symbol:",
                    "'='",
                    "'<'",
                    "'->'",
                    section2
            );

            Question q8 = new TrueOrFalse(
                    "I can declare a variable as int and store a float later",
                    "False",
                    section2
            );

            Question q9 = new TrueOrFalse(
                    "I can declare a variable and store its value later",
                    "True",
                    section2
            );

            registrationService.register(request);

            appUserService.enableAppUser("admin");

            chapterRepository.saveAll(
                    List.of(chapter1, chapter2)
            );

            sectionRepository.saveAll(
                    List.of(section1, section2, section3, section4, section5)
            );

            multipleChoiceRepository.saveAll(
                    List.of((MultipleChoice)q1, (MultipleChoice)q2, (MultipleChoice) q5, (MultipleChoice) q6)
            );

            trueOrFalseRepository.saveAll(
                    List.of((TrueOrFalse) q3, (TrueOrFalse)q4, (TrueOrFalse) q7, (TrueOrFalse) q8, (TrueOrFalse) q9)
            );
        };
    }
}
