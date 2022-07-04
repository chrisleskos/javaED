package com.javaED.service;

import com.javaED.model.account.AppUser;
import com.javaED.model.account.userProgress.Mistake;
import com.javaED.model.material.Chapter;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;
import com.javaED.model.test.GeneralTest;
import com.javaED.model.test.Test;
import com.javaED.model.test.TestAnswer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class TestService {

    private final QuestionService questionService;
    private final MistakeService mistakeService;

    public TestService(QuestionService questionService, MistakeService mistakeService) {
        this.questionService = questionService;
        this.mistakeService = mistakeService;
    }

    public int checkTest(TestAnswer[] testAnswers, AppUser appUser) {
        int score = 0;

        for (TestAnswer testAnswer:
                testAnswers) {
            Question question = questionService.getQuestion(testAnswer.getId());
            boolean correct = question.checkAnswer(testAnswer.getGivenAnswer());
            if (correct) {
                score++;
                try {
                    Mistake mistake = mistakeService.getMistake(appUser, question.getSection())
                            .orElseThrow(() -> new Exception());
                    mistake.decreaseCount();
                    mistakeService.updateCount(mistake);
                } catch (Exception e) { }
            }
            else {
                testAnswer.setCorrect(false);
                Mistake mistake = null;
                try {
                    mistake = mistakeService.getMistake(appUser, question.getSection())
                        .orElseThrow(() -> new Exception());
                    System.out.println("\n\n\n\n Mistake: " + mistake.toString() + "\n\n\n\n");
                    mistake.increaseCount();
                    mistakeService.updateCount(mistake);
                    System.out.println("\n\n\n\nSUCCESSFULLY UPDATED!! \n\n\n\n");
                } catch (Exception e) {
                    mistake = new Mistake(appUser, question.getSection());
                    mistakeService.saveMistake(mistake);
                }

                testAnswer.setMistake_count(mistake.getCount());
                testAnswer.setSection_title(question.getSection().getChapter().getTitle() + ": " + question.getSection().getTitle());
                testAnswer.setCorrectAnswer(question.getCorrectAnswer());
            }

            testAnswer.setCorrect(correct);
        }

        return score;
    }

    abstract public void saveTest(Test submittedTest);
}
