package com.Quiz.QuizApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.Quiz.QuizApp.Model.Quiz;
@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {



}
