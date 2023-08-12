package com.mylearning.sprintgboot.firstrestapi.survey;

import com.mylearning.sprintgboot.firstrestapi.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
}
