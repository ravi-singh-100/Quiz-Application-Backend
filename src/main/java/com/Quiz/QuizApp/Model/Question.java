package com.Quiz.QuizApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String questionTitle;
    @NotNull
    String option1;
    @NotNull
    String option2;
    @NotNull
    String option3;
    @NotNull
    String option4;
    @NotNull
    String rightAnswer;
    @NotNull
    String difficultyLevel;
    @NotNull
    String category;
}
