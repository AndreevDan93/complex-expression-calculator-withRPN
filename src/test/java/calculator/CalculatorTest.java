package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void calculateTest1() {
        Calculator calculator = new Calculator();
        assertEquals(-5, calculator.calculate("-7+2"));
    }
    @Test
    void calculateTest2() {
        Calculator calculator = new Calculator();
        assertEquals(-4, calculator.calculate("-(2+2)"));
    }
    @Test
    void calculateTest3() {
        Calculator calculator = new Calculator();
        assertEquals(-4, calculator.calculate("-4"));
    }
    @Test
    void calculateTest4() {
        Calculator calculator = new Calculator();
        assertEquals(-7, calculator.calculate("-4+(-3)"));
    }
    @Test
    void calculateTest5() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.calculate("-4-(-3-3)"));
    }
    @Test
    void calculateTest6() {
        Calculator calculator = new Calculator();
        assertEquals(-10, calculator.calculate("2*(-7+2)"));
    }
    @Test
    void calculateTest7() {
        Calculator calculator = new Calculator();
        assertEquals(-5, calculator.calculate("(-7+2)"));
    }
    @Test
    void calculateTest8() {
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.calculate("(-2+2*3)*2+1"));
    }
    @Test
    void calculateTest9() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.calculate("2+2*2+(-7+2)"));
    }
    @Test
    void calculateTest10() {
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.calculate("(-2+2*3)*2+(-1)"));
    }
    @Test
    void calculateTest11() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.calculate("2+2"));
    }
    @Test
    void calculateTest12() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("2+2*2"));
    }
    @Test
    void calculateTest13() {
        Calculator calculator = new Calculator();
        assertEquals(16, calculator.calculate("2+2*(3+4)"));
    }
    @Test
    void calculateTest14() {
        Calculator calculator = new Calculator();
        assertEquals(-34, calculator.calculate("72/12-8*(1+4)"));
    }
    @Test
    void calculateTest15() {
        Calculator calculator = new Calculator();
        assertEquals(42, calculator.calculate("2*(3+2*(1+2*(1+3)))"));
    }
    @Test
    void calculateTest16() {
        Calculator calculator = new Calculator();
        assertEquals(66, calculator.calculate("2*(3+2*(1+2*(1+3)+(1+5)))"));
    }


}