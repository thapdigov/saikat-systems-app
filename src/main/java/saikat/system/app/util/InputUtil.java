package saikat.system.app.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer getIntegerInput(String title) {
        while (true) {
            System.out.print(title + ": ");
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
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
                Double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter a valid double");
                scanner.nextLine();
            }
        }
    }

    public static String getStringInput(String title) {
        System.out.print(title + ": ");
        return scanner.nextLine();
    }
}
