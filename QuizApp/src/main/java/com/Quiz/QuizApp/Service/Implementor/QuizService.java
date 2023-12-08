package com.Quiz.QuizApp.Service.Implementor;


import com.Quiz.QuizApp.Model.Question;
import com.Quiz.QuizApp.Model.QuestionWrapper;
import com.Quiz.QuizApp.Model.Quiz;
import com.Quiz.QuizApp.Model.SelectedOption;
import com.Quiz.QuizApp.Repository.QuestionRepo;
import com.Quiz.QuizApp.Repository.QuizRepo;
import com.Quiz.QuizApp.Service.QuizServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements QuizServiceInterface {
  @Autowired
  QuizRepo quizRepo;
  @Autowired
    QuestionRepo questionRepo;
@Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question>list= questionRepo.findAllByCategory(category,numQ);
        Quiz quiz=new Quiz();

                quiz.setTitle(title);
        quiz.setQuestionList(list);
        quizRepo.save(quiz);
return new ResponseEntity<>("Success", HttpStatusCode.valueOf(201));
    }
    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id){
    List<QuestionWrapper>list=new ArrayList<>();
    Optional<Quiz> quiz=quizRepo.findById(id);
   List<Question>questionFromDB=quiz.get().getQuestionList();
   for(Question q:questionFromDB){
       list.add(new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getDifficultyLevel()));
   }
    return new ResponseEntity<>(list,HttpStatusCode.valueOf(200));
    }
    @Override
    public ResponseEntity<Integer> submitQuiz(Integer id,List<SelectedOption>selectedOption){
    Integer count=0;
    Optional<Quiz> quiz=quizRepo.findById(id);
    List<Question>question=quiz.get().getQuestionList();
    for(SelectedOption so:selectedOption){
       Optional<Question> q=questionRepo.findById(so.getQuestionId());
        if(q.get().getRightAnswer().equals(so.getAnswerSelected())) count++;

    }
    return new ResponseEntity<>(count,HttpStatusCode.valueOf(200));

    }
}
