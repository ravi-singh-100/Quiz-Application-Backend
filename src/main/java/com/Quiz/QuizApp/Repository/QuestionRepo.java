package com.Quiz.QuizApp.Repository;

import com.Quiz.QuizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question>findByCategory(String category);

@Query(value = "Select * from question q where q.category = :category ORDER BY RAND() LIMIT :numQ" ,nativeQuery = true)
List<Question> findAllByCategory(String category, int numQ);
}
