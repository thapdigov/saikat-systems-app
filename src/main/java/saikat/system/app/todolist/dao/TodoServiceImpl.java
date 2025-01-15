package saikat.system.app.todolist.dao;

import saikat.system.app.todolist.model.Task;

import java.util.ArrayList;
import java.util.List;

import static saikat.system.app.util.InputUtil.getIntegerInput;
import static saikat.system.app.util.InputUtil.getStringInput;

public class TodoServiceImpl implements TodoService {
    private final List<Task> TASK_LIST = new ArrayList<>();

    @Override
    public void create() {
        String taskTitle = getStringInput("Enter the task title");
        Task task = new Task(taskTitle, false);
        TASK_LIST.add(task);
        System.out.println("Task successfully added: " + taskTitle);
    }

    @Override
    public void printAll() {
        if (TASK_LIST.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("All tasks:");
            TASK_LIST.forEach(System.out::println);
        }
    }


    @Override
    public void getByTitle(String title) {
        System.out.println("Searching for tasks with title: " + title);
        TASK_LIST.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title))
                .forEach(System.out::println);
    }

    @Override
    public void markAsCompleted(String title) {
        TASK_LIST.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresentOrElse(
                        task -> {
                            task.setStatus(true);
                            System.out.println("Task marked as completed: " + title);
                        },
                        () -> System.out.println("No task found with the given title!")
                );
    }

    public void start() {
        System.out.println("""
                Welcome to the Todo Application!
                """);
        boolean flag = true;
        while (flag) {
            int choice = getIntegerInput("""
                    Choose an option:
                    1. Create Todo
                    2. Print All Todos
                    3. Get Todo by Title
                    4. Mark Todo as Completed
                    5. Exit
                    """);
            switch (choice) {
                case 1 -> create();
                case 2 -> printAll();
                case 3 -> {
                    String title = getStringInput("Enter the title");
                    getByTitle(title);
                }
                case 4 -> {
                    String title = getStringInput("Enter the title of the task to mark as completed");
                    markAsCompleted(title);
                }
                case 5 -> {
                    flag = false;
                    System.out.println("Thank you for using the Todo Application!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

