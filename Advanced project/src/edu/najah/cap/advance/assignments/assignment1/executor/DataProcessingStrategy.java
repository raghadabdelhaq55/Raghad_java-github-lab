package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.job.Job;

public class DataProcessingStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[DataStrategy] Starting data processing with config: " + job.getConfig());
        connection.execute("UPDATE data_jobs SET status='DONE' WHERE job_id='" + job.getId() + "'");
        System.out.println("[DataStrategy] Data processing completed successfully");
    }
}
