package com.mylearning.sprintgboot.firstrestapi.survey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

    // http://localhost:8080/surveys/survey1/questions/Question1
    String str = """
                
            """;

    private static String SPECIFIC_URL_STR = "/surveys/survey1/questions/Question1";
    @Autowired
    TestRestTemplate template;

    @Test
    void retrieveQuestionById_basicScenario() {
        ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_URL_STR, String.class);
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getHeaders());
    }
}
