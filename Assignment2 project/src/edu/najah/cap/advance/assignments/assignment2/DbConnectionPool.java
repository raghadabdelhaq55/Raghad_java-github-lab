package edu.najah.cap.advance.assignments.assignment2;

import java.util.ArrayDeque;
import java.util.Queue;

public class DbConnectionPool {

    private final Queue<DbConnection> available = new ArrayDeque<>();

    public DbConnectionPool(int size) {
        for (int i = 1; i <= size; i++) {
            available.add(new DbConnection("conn-" + i));
        }
    }

    public synchronized DbConnection acquire() {
        if (available.isEmpty()) {
            return new DbConnection("temp");
        }
        return available.poll();
    }

    public synchronized void release(DbConnection connection) {
        available.offer(connection);
    }
}
