package saikat.system.app.todolist.model;

public class Task {
    private String title;
    private boolean status;

    public Task(String title, boolean status) {
        this.title = title;
        this.status = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Status: " + (status ? "Completed" : "Not Completed");
    }
}
