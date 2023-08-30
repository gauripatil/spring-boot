package com.mylearning.sprintgboot.firstrestapi.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

    // http://localhost:8080/surveys/survey1/questions/Question1
    private static String SPECIFIC_URL_STR = "/surveys/survey1/questions/Question1";
    private static String ALL_QUESTIONS_URL_STR = "/surveys/survey1/questions";
    private static String ADD_NEW_QUESTION_STR = "/surveys/Survey1/questions";
    @Autowired
    TestRestTemplate template;

    @Test
    void retrieveQuestionById_basicScenario() throws JSONException {
        ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_URL_STR, String.class);
        System.out.println(responseEntity.getBody());
        String expectedResponseStr = """
                {
                    "id":"Question1",
                    "description":"Most Popular Cloud Platform Today",
                    "correctAnswer":"AWS",
                    "option":["AWS","Azure","Google Cloud","Oracle Cloud"]
                }
            """;
        //

        System.out.println(responseEntity.getHeaders());
        // [Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Sat, 26 Aug 2023 16:16:43 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponseStr, responseEntity.getBody(), false);




    }

    @Test
    void getAllSurveyQuestions_basicScenario() throws JSONException {
        ResponseEntity<String> responseEntity = template.getForEntity(ALL_QUESTIONS_URL_STR, String.class);
        System.out.println(responseEntity.getBody());
        String expectedResponseStr =
               """
                    [
                         {
                             "id": "Question1"
                         },
                         {
                             "id": "Question2"
                         },
                         {
                             "id": "Question3"
                         }
                    ]
                         
               """;

        System.out.println(responseEntity.getHeaders());
        // [Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Sat, 26 Aug 2023 16:16:43 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponseStr, responseEntity.getBody(), false);
    }
    @Test
    void addNewSurveyQuestion_basicScenario() throws JSONException {
        ///surveys/Survey1/questions
        String body =
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
        // Status 201
        // Header - Content-Type = application/json
        //  Location uri - response

        ResponseEntity<String> responseEntity = template.getForEntity(ADD_NEW_QUESTION_STR, String.class);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        HttpEntity<String> httpEntity = new HttpEntity<String>(body, httpHeaders);
        ResponseEntity<String> exchange =
                template.exchange(ADD_NEW_QUESTION_STR, HttpMethod.POST, httpEntity, String.class);


        System.out.println(exchange.getHeaders());
        System.out.println(exchange.getBody());
        //[Location:"http://localhost:49806/surveys/Survey1/questions/1296842013", Content-Length:"0", Date:"Wed, 30 Aug 2023 16:06:48 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]
        //null

        assertTrue(exchange.getStatusCode().is2xxSuccessful());
        assertTrue(exchange.getHeaders().get("Location").get(0).contains("/surveys/Survey1/questions/"));



    }
}
