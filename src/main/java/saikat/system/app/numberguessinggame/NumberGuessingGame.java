package saikat.system.app.numberguessinggame;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static saikat.system.app.util.InputUtil.getIntegerInput;
import static saikat.system.app.util.InputUtil.getStringInput;

public class NumberGuessingGame {
    private final Random random = new Random();

    public void gameStart() {
        System.out.println("----------- Welcome to the Number Guessing Game -----------");

        String name = getStringInput("Enter your name");
        int randomNumber = random.nextInt(101);
        HashSet<Integer> enteredNumbers = new HashSet<>();
        int count = 0;
        int enterNumber;

        System.out.println("Guess a number between 0 and 100!");

        while (true) {
            enterNumber = getIntegerInput("Enter your guess");

            if (enterNumber < 0 || enterNumber > 100) {
                System.out.println("Please enter a number between 0 and 100!");
                continue;
            }

            if (!enteredNumbers.add(enterNumber)) {
                System.out.println("You already guessed this number! Try a different one!");
                continue;
            }
            count++;

            if (enterNumber > randomNumber) {
                System.out.println("Too high! Try a smaller number!");
            } else if (enterNumber < randomNumber) {
                System.out.println("Too low! Try a larger number!");
            } else {
                System.out.println("\nCongrats " + name.toUpperCase() + "! You guessed the number in " + count + " attempts!");
                break;
            }
        }
        System.out.print("The numbers you guessed: ");
        List<Integer> sortedHasSet = enteredNumbers.stream().sorted().toList();
        for (Integer integer : sortedHasSet) {
            System.out.print(integer + " ");
        }
    }
}
