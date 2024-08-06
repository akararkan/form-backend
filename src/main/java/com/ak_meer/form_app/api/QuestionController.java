package com.ak_meer.form_app.api;

import com.ak_meer.form_app.model.Question;
import com.ak_meer.form_app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/getAllQuestion")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getAllQuestions().stream()
                .filter(question -> question.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/addQuestion")
    public Question createQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @PutMapping("/updateQuestion/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Question existingQuestion = questionService.getAllQuestions().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingQuestion != null) {
            existingQuestion.setText(question.getText());
            existingQuestion.setType(question.getType());
            existingQuestion.setOptions(question.getOptions());
            return questionService.saveQuestion(existingQuestion);
        }

        return null;
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}