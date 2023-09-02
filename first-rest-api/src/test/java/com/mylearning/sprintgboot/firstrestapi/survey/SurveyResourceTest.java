package com.mylearning.sprintgboot.firstrestapi.survey;

import com.mylearning.sprintgboot.firstrestapi.SurveyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = SurveyResource.class)
public class SurveyResourceTest {


    // Mock -> surveyService.getQuestionById(surveyId, questionsId);
    @MockBean
    private SurveyService surveyService;

    @Autowired
    private MockMvc mockMvc;


    // Fire a request
    // /surveys/{surveyId}/questions/{questionsId}
    // GET


    public String SPECIFIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions/Question1";

    @Test
    void retrieveQuestionById_404Scenario() throws Exception {

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
        System.out.println(mvcResult.getResponse().getContentAsString());

    }
}
