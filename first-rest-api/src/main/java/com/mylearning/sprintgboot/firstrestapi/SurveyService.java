package com.mylearning.sprintgboot.firstrestapi;

import com.mylearning.sprintgboot.firstrestapi.survey.Question;
import com.mylearning.sprintgboot.firstrestapi.survey.Survey;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class SurveyService {

    public static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));

        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);

    }

    public List<Survey> retrieveAllSurveys() {
        return surveys;
    }

    public Survey getSurveyById(String surveyId) {
        Predicate<? super Survey> predicate = survey -> survey.getId().equalsIgnoreCase(surveyId);
        Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();
        if(optionalSurvey.isEmpty()) return null;
        return optionalSurvey.get();
    }

    public List<Question> getAllQuestions(String surveyId) {
        Survey survey = getSurveyById(surveyId);
        if(survey == null) return null;

        return survey.getQuestions();
    }

    public Question getQuestionById(String surveyId, String questionsId) {
        List<Question> questions = getAllQuestions(surveyId);
        Predicate<? super Question> predicate = question -> question.getId().equalsIgnoreCase(questionsId);
        Optional<Question> optionalQuestion = questions.stream().filter(predicate).findFirst();
        if(optionalQuestion.isEmpty()) return null;
        return optionalQuestion.get();
    }

    public String addNewSurveyQuestion(String surveyId, Question question) {
        Survey survey = this.getSurveyById(surveyId);
        if(null == survey) return null;

        // Generate random Id for question
        question.setId(generateRandomId());

        survey.getQuestions().add(question);
        return question.getId().toString();
    }

    private static String generateRandomId() {
        SecureRandom secureRandom = new SecureRandom();
        String randomString = new BigInteger(32, secureRandom).toString();
        return randomString;
    }

    public boolean deleteSurveyQuestion(String surveyId, String questionsId) {
        List<Question> surveyQuestions =  getAllQuestions(surveyId);
        boolean removed = surveyQuestions.removeIf(question -> question.getId().equalsIgnoreCase(questionsId));
        return removed;
    }

    public void updateSurveyQuestion(String surveyId, String questionsId, Question question) {
        List<Question> surveyQuestions =  getAllQuestions(surveyId);
        surveyQuestions.removeIf(q -> q.getId().equalsIgnoreCase(questionsId));
        surveyQuestions.add(question);
    }
}
