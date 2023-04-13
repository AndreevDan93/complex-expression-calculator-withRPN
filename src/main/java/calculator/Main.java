package calculator;

public class Main {
    public static void main(String[] args) {
        // for example
        String expression = "72/12 - 8*(1 + 4)";
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(expression)); // -34
    }
}