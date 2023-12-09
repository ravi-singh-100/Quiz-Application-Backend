package com.Quiz.QuizApp.Service;

import com.Quiz.QuizApp.Model.QuestionWrapper;
import com.Quiz.QuizApp.Model.SelectedOption;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizServiceInterface {
    ResponseEntity<String> createQuiz(String category,int numQ,String title);

    ResponseEntity<List<QuestionWrapper>> getQuizById(int id);
    ResponseEntity<Integer> submitQuiz(Integer id,List<SelectedOption>selectedOption);
}
