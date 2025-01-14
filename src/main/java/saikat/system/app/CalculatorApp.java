package saikat.system.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class CalculatorApp {
    private static final Scanner scanner = new Scanner(System.in);

    public void useCalculator() {
        boolean flag = true;
        while (flag) {
            int choise = getIntegerInput("""
                    -----------------
                    Your choise:
                    1.Use calculator
                    2.Exit
                    -----------------""");
            switch (choise) {
                case 1 -> runCalculator();
                case 2 -> flag = false;
                default -> System.out.println("Invalid input");
            }
        }
    }

    public void runCalculator() {
        System.out.println("\n\t\t\tThis is Calculator!");
        Double a = getDoubleInput("Enter the first number");
        Double b = getDoubleInput("Enter the second number");
        char operator = getStringInput("Enter the operator").charAt(0);
        Set<Character> validOperators = Set.of('+', '-', '*', '/');
        while (!validOperators.contains(operator)) {
            System.out.println("Invalid operator! Please enter one of +, -, *, /");
            operator = getStringInput("Enter the operator").charAt(0);
        }
        double answer = 0.0;
        switch (operator) {
            case '+' -> answer = addition(a, b);
            case '-' -> answer = subtraction(a, b);
            case '*' -> answer = multiplication(a, b);
            case '/' -> answer = divison(a, b);
            default -> System.out.println("Invalid choise!");
        }
        if (answer % 1 == 0) {
            System.out.printf("Your answer: %d%n", (int) answer);
        } else {
            System.out.printf("Your answer: %.2f%n", answer);
        }
    }

    public static Double addition(Double a, Double b) {
        return a + b;
    }

    public static Double subtraction(Double a, Double b) {
        return a - b;
    }

    public static Double multiplication(Double a, Double b) {
        return a * b;
    }

    public static Double divison(Double a, Double b) {
        while (true) {
            try {
                if (b == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero! Please enter a non-zero denominator.");
                }
                return a / b;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                b = getDoubleInput("Enter a new denominator");
            }
        }
    }

    public static Integer getIntegerInput(String title) {
        while (true) {
            System.out.print(title + ": ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter a valid integer!");
                scanner.nextLine();
            }
        }
    }

    public static Double getDoubleInput(String title) {
        while (true) {
            System.out.print(title + ": ");
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter a valid double");
                scanner.nextLine();
            }
        }
    }

    public static String getStringInput(String title) {
        System.out.print(title + ": ");
        return scanner.next();
    }
}
