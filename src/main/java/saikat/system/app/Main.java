package saikat.system.app;

import saikat.system.app.calculator.CalculatorApp;
import saikat.system.app.temperaturconverter.TemperatureConverter;
import saikat.system.app.todolist.dao.TodoService;
import saikat.system.app.todolist.dao.TodoServiceImpl;

public class Main {
    public static void main(String[] args) {

//        //Task1
//        CalculatorApp calculatorApp = new CalculatorApp();
//        calculatorApp.useCalculator();
//        //Task2
//        TemperatureConverter temperaturConverter = new TemperatureConverter();
//        temperaturConverter.converter();
        TodoServiceImpl todoService = new TodoServiceImpl();
        todoService.start();
    }
}
