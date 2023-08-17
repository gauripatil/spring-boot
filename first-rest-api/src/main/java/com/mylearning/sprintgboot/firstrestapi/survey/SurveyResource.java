
package com.mylearning.sprintgboot.firstrestapi.survey;

import com.mylearning.sprintgboot.firstrestapi.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyResource {

    SurveyService surveyService;
    public SurveyResource(SurveyService surveyService) {
        super();
        this.surveyService = surveyService;
    }

    // /surveys => surveys
    @RequestMapping("/surveys")
    public List<Survey> retrieveAllSurveys() {
        return surveyService.retrieveAllSurveys();
    }

    // /surveys/survey1 => survey
    @RequestMapping("/surveys/{surveyId}")
    public Survey retrieveSurveyById(@PathVariable String surveyId) {
        Survey survey = surveyService.getSurveyById(surveyId);

        if(survey==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return survey;
    }

    // Get all questions survey question
    // /surveys/survey1/questions => all questions
    @RequestMapping("/surveys/{surveyId}/questions")
    public List<Question> getAllSurveyQuestions(@PathVariable String surveyId) {
        List<Question> questions = surveyService.getAllQuestions(surveyId);

        if(questions==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return questions;
    }

    // Get Specific survey question
    // /surveys/survey1/questions/question1 => specific question
    @RequestMapping("/surveys/{surveyId}/questions/{questionsId}")
    public Question retrieveQuestionById(@PathVariable String surveyId, @PathVariable String questionsId) {
        Question questions = surveyService.getQuestionById(surveyId, questionsId);

        if(questions==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return questions;
    }


    /*
    * add question to specific survey
    * {
    "id": "SOME_ID",
    "description": "Your Favorite Cloud Platform",
    "options": [
        "AWS",
        "Azure",
        "Google Cloud",
        "Oracle Cloud"
    ],
    "correctAnswer": "Google Cloud"
    }
}   */

    @RequestMapping(value="/surveys/{surveyId}/questions", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {
        String questionId = surveyService.addNewSurveyQuestion(surveyId, question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{questionId}").buildAndExpand(questionId).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value="/surveys/{surveyId}/questions/{questionsId}", method = RequestMethod.DELETE)
    public String deleteSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionsId) {
        boolean removed = surveyService.deleteSurveyQuestion(surveyId, questionsId);

        if(!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return questionsId;
    }
}
