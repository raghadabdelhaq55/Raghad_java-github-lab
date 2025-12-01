package edu.najah.cap.advance.assignments.assignment1.connections;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final int MAX_CONNECTIONS = 10;
    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private final List<Connection> connections = new ArrayList<>();
    private int currentIndex = 0;

    private ConnectionPool() {
        for (int i = 1; i <= MAX_CONNECTIONS; i++) {
            connections.add(new Connection("Conn-" + i));
        }
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public synchronized Connection acquire() {
        Connection connection = connections.get(currentIndex);
        currentIndex = (currentIndex + 1) % connections.size();
        System.out.println("[ConnectionPool] Acquired connection: " + connection.getId());
        return connection;
    }

    public synchronized void release(Connection connection) {
        if (connection != null) {
            System.out.println("[ConnectionPool] Released connection: " + connection.getId());
        }
    }
}
