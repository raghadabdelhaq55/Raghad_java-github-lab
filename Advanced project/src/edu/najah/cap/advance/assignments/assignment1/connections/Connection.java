package edu.najah.cap.advance.assignments.assignment1.connections;

public class Connection {

    private final String id;  // Conn-1, Conn-2, ...
    private boolean open = true;

    public Connection(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void execute(String query) {
        if (!open) {
            throw new IllegalStateException("Connection is closed");
        }
        System.out.println("[Conn " + id + "] Executing query: " + query);
    }

    public void close() {
        open = false;
    }
}
