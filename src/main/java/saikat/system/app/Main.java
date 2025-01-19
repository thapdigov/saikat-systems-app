package saikat.system.app;

import saikat.system.app.basicbankingsystem.BankAccount;
import saikat.system.app.calculatorapplication.CalculatorApp;
import saikat.system.app.numberguessinggame.NumberGuessingGame;
import saikat.system.app.temperaturconverter.TemperatureConverter;
import saikat.system.app.textfileanalyzer.TextFileAnalyzer;
import saikat.system.app.todolistapplication.dao.TodoServiceImpl;

public class Main {
    public static void main(String[] args) {

        //Task1
        CalculatorApp calculatorApp = new CalculatorApp();
        calculatorApp.useCalculator();
        //Task2
        TemperatureConverter temperaturConverte = new TemperatureConverter();
        temperaturConverte.converter();
        //Task3
        TodoServiceImpl todoService = new TodoServiceImpl();
        todoService.start();
        //Task4
        NumberGuessingGame numberGuessingGame = new NumberGuessingGame();
        numberGuessingGame.gameStart();
        //Task5
        TextFileAnalyzer textFileAnalyzer = new TextFileAnalyzer();
        textFileAnalyzer.textFileAnalyzer();
        //Task6
        BankAccount bankAccount = new BankAccount();
        bankAccount.start();
    }
}
