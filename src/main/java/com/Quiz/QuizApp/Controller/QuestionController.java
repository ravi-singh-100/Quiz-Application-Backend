package com.Quiz.QuizApp.Controller;

import com.Quiz.QuizApp.Model.Question;
import com.Quiz.QuizApp.Service.Implementor.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("getAll")
    public ResponseEntity<List<Question>> getAll(){
        return questionService.getAllQuestion();
    }

    @PostMapping("update")
    public  ResponseEntity<String> updateQuestion(@RequestBody Question question){
       return questionService.updateQuestion(question);
    }

    @GetMapping("getByCategory/{category}")
    public ResponseEntity<List<Question>>getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteQuestion(@RequestParam("id") Integer id){
        return questionService.deleteQuestion(id);
    }
}
