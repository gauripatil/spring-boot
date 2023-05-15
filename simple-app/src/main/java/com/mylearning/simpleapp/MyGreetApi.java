package com.mylearning.simpleapp;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class MyGreetApi {

    @GetMapping(path = "/welcome")
    public ResponseEntity<Object> greet() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Alex");
        map.put("dob", LocalDate.of(1999, 10, 25));
        map.put("phone", 998989889);
        return ResponseEntity.status(200).body(map);

//        return ResponseEntity.status(200).body("Hello World!!");
    }

    // http://localhost:9090/v1/store
    // {
    //	"id": 1,
    //	"name": "Gauri",
    //	"salary": "1000"
    //}
    @PostMapping(path = "/store", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody Employee emp) {
        return ResponseEntity.status(200).body("Employee created successfully : " + emp.getId());
    }
}
