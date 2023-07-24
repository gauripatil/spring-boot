package com.learning.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {

    @Test
     void test() {
        MyMath myMath = new MyMath();
        int[] array = {1,2,3};
        int result  = myMath.calculateSum(array);
        System.out.println(result);
        int expectedResult = 6;
        assertEquals(result, expectedResult);
    }
}