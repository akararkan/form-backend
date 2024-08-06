package com.ak_meer.form_app.repo;

import com.ak_meer.form_app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}