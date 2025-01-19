package saikat.system.app.todolistapplication.dao;

public interface TodoService {

    void create();

    void printAll();

    void getByTitle(String title);

    void markAsCompleted(String title);
}
