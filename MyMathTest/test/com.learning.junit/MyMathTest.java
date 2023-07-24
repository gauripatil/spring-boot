package com.learning.junit;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void calculateSum() {
        MyMathTest myMathTest = new MyMathTest();
        int result  = myMathTest.calculateSum({1, 2, 3});
        System.out.println(result);

    }
}