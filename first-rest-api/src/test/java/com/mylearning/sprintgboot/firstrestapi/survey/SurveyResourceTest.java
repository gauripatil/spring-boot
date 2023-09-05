package com.mylearning.sprintgboot.firstrestapi.survey;

import com.mylearning.sprintgboot.firstrestapi.SurveyService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

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
    public String GENERIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions";

    @Test
    void retrieveQuestionById_404Scenario() throws Exception {

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    void retrieveQuestionById_basicScenario() throws Exception {

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);


        // mock response when request is fired when Survey1 & Question1
        Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        // stubbing survey service

        when(surveyService.getQuestionById("Survey1", "Question1")).thenReturn(question1);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
        System.out.println(mvcResult.getResponse().getContentAsString());

        String expectedResult = """
                   {
                        "id":"Question1",
                        "description":"Most Popular Cloud Platform Today",
                        "correctAnswer":"AWS",
                        "option":["AWS","Azure","Google Cloud","Oracle Cloud"]
                    }                       
                """;
        // asserts
        assertEquals(200, mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expectedResult, mvcResult.getResponse().getContentAsString(), false);

    }


    // Required things for test case - input & output
    // addNewSurveyQuestion
    // POST
    // http://localhost:8080/surveys/survey1/questions
    // 201
    //Location: http://localhost:8080/surveys/survey1/questions/8723617368
    // request body - question object to add

    @Test
    void addNewSurveyQuestion_basicScenario() throws Exception {

        String requestBody =
                """
                    {
                        "description": "Most Popular Cloud Platform Today",
                        "correctAnswer": "AWS123",
                        "option": [
                            "AWS123",
                            "Azure",
                            "Google Cloud",
                            "Oracle Cloud"
                        ]
                    }
                """;

        // mocking service
        when(surveyService.addNewSurveyQuestion(anyString(),any())).thenReturn("SOME_ID");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(GENERIC_QUESTION_URL) //post method
                .accept(MediaType.APPLICATION_JSON) // we expect json response
                .content(requestBody) // content  - question to add in json format
                .contentType(MediaType.APPLICATION_JSON);// req content type - json

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
        String location = mvcResult.getResponse().getHeader("Location");
        System.out.println(location);

        // asserts
        assertEquals(201, mvcResult.getResponse().getStatus());
        assertTrue(location.contains("/surveys/Survey1/questions/SOME_ID"));
    }

}
