package edu.najah.cap.advance.assignments.assignment1.job;

import edu.najah.cap.advance.assignments.assignment1.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.executor.JobStrategy;
import edu.najah.cap.advance.assignments.assignment1.executor.StrategyRegistry;

public class Job {

    private final String id;
    private final JobType type;
    private final String name;    // اسم الـ job (Standard Email, Monthly Report, ...)
    private final String config;  // إعدادات job (format=HTML;priority=normal)
    private final JobStrategy strategy;

    public Job(String id, JobType type, String name, String config) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.config = config;
        this.strategy = StrategyRegistry.getStrategy(type);
    }

    public String getId() {
        return id;
    }

    public JobType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getConfig() {
        return config;
    }

    public void executeWithStrategy(Connection connection) {
        strategy.execute(this, connection);
    }
}
