package com.Quiz.QuizApp.Model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class SelectedOption {
    @NotNull
    private Integer questionId;
    @NotNull
    private String answerSelected;
}
