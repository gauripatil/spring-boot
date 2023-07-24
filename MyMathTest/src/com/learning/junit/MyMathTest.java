package com.learning.junit;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void test() {
        MyMath myMath = new MyMath();
        int[] array = {1,2,3};
        int result  = myMath.calculateSum(array);
        System.out.println(result);
    }
}