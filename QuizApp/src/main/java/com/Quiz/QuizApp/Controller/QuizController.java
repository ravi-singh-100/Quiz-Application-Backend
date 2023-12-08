package com.Quiz.QuizApp.Controller;

import com.Quiz.QuizApp.Model.QuestionWrapper;
import com.Quiz.QuizApp.Model.SelectedOption;
import com.Quiz.QuizApp.Service.Implementor.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        try{
            quizService.createQuiz(category,numQ,title);
            return new ResponseEntity<>("success", HttpStatusCode.valueOf(201));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed",HttpStatusCode.valueOf(404));

    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizBYId(@PathVariable int id){
       return quizService.getQuizById(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id ,@RequestBody List<SelectedOption>selectedOption){
        return quizService.submitQuiz(id,selectedOption);
    }
}
