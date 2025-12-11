package edu.najah.cap.advance.assignments.assignment2;

public class DbConnection {

    private final String name;

    public DbConnection(String name) {
        this.name = name;
    }

    public void save(String id, String data) {
        System.out.println("[DB " + name + "] Saved " + id + ":" + data);
    }
}
