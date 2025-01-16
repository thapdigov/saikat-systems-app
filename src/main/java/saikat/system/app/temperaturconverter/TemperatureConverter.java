package saikat.system.app.temperaturconverter;

import static saikat.system.app.util.InputUtil.*;

public class TemperatureConverter {
    public void converter() {
        System.out.println("""
                    
                    \t\t\tWelcome to the Temperature Converter Program!
                """);
        boolean flag = true;
        while (flag) {
            int choice = getIntegerInput("""
                    Which conversion do you want to do?
                    1. Celsius to Fahrenheit
                    2. Fahrenheit to Celsius
                    3. Exit

                    Enter your choice""");
            double convertedTemp = 0.0;
            switch (choice) {
                case 1 -> {
                    double celsius = getDoubleInput("Enter the temperature in Celsius");
                    convertedTemp = celsius * 9 / 5 + 32;
                    System.out.printf("Temperature in Fahrenheit: %.2f°F\n\n", convertedTemp);
                }
                case 2 -> {
                    double fahrenheit = getDoubleInput("Enter the temperature in Fahrenheit");
                    convertedTemp = (fahrenheit - 32) * 5 / 9;
                    System.out.printf("Temperature in Celsius: %.2f°C\n\n", convertedTemp);
                }
                case 3 -> flag = false;
                default -> System.out.println("Invalid input!");
            }
        }
    }
}
