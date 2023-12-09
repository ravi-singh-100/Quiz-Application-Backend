package com.Quiz.QuizApp.Service.Implementor;

import com.Quiz.QuizApp.Model.Question;
import com.Quiz.QuizApp.Service.QuestionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService implements QuestionServiceInterface {
    @Autowired
    com.Quiz.QuizApp.Repository.QuestionRepo questionRepo;
    public  ResponseEntity<List<Question>> getAllQuestion(){
        try{
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return  new ResponseEntity<>(new ArrayList<>(),HttpStatusCode.valueOf(404));
    }
    public ResponseEntity<String> updateQuestion(Question question){
        try {
            questionRepo.save(question);
            return new ResponseEntity<>("Success", HttpStatusCode.valueOf(201));
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>>getByCategory(String category){
        try{
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<String> deleteQuestion(Integer id){
        try {
            questionRepo.deleteById(id);
            return new ResponseEntity<>("success", HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.valueOf(404));
    }
}
