package com.learning.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {
    MyMath myMath = new MyMath();
    @Test
     void calculateSUm_ThreeMemberArray() {
        assertEquals(6, myMath.calculateSum(new int[]{1,2,3}));
    }

    @Test
    void calculateSUm_ZeroLengthArray() {
        assertEquals(0, myMath.calculateSum(new int[]{}));
    }
}