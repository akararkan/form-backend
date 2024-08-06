package com.ak_meer.form_app.service;


import com.ak_meer.form_app.model.Question;
import com.ak_meer.form_app.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        // Assuming you're using JPA and have a QuestionRepository
        questionRepository.deleteById(id);
    }
    public String getQuestionText(Long questionId) {
        return questionRepository.findById(questionId)
                .map(Question::getText)
                .orElse("Unknown question"); // Fallback in case the question is not found
    }
}