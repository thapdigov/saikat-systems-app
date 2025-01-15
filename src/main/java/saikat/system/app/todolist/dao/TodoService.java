package saikat.system.app.todolist.dao;

public interface TodoService {

    void create();

    void printAll();

    void getByTitle(String title);

    void markAsCompleted(String title);
}
