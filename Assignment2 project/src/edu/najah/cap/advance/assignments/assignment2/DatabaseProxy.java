package edu.najah.cap.advance.assignments.assignment2;

public class DatabaseProxy implements Database {

    private final DbConnectionPool pool;

    public DatabaseProxy(DbConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public void save(String id, String data) {
        DbConnection connection = pool.acquire();
        try {
            connection.save(id, data);
        } finally {
            pool.release(connection);
        }
    }
}
