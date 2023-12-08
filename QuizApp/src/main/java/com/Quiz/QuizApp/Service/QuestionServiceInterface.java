package com.Quiz.QuizApp.Service;

import com.Quiz.QuizApp.Model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionServiceInterface {

    ResponseEntity<List<Question>> getAllQuestion();

    ResponseEntity<String> updateQuestion(Question question);

    ResponseEntity<List<Question>> getByCategory(String category);
    ResponseEntity<String> deleteQuestion(Integer id);
}
