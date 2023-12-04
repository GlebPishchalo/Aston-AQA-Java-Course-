package com.aston.aqa;

import com.aston.aqa.lesson12.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testCalculateFactorialZero() {
        assertEquals(1, Factorial.calculateFactorial(0));
    }

    @Test
    void testCalculateFactorialOne() {
        assertEquals(1, Factorial.calculateFactorial(1));
    }

    @Test
    void testCalculateFactorialPositiveNumber() {
        assertEquals(120, Factorial.calculateFactorial(5));
    }

    @Test
    void testCalculateFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculateFactorial(-5));
    }
}