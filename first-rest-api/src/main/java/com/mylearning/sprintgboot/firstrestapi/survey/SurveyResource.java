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

    // /surveys => surveys
    @RequestMapping("/surveys/{surveyId}")
    public Survey getSurveyById(@PathVariable String surveyId) {
        Survey survey = surveyService.getSurveyById(surveyId);

        if(survey==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return survey;
    }
}
