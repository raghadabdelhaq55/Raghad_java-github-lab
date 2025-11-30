package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.job.Job;

public class ReportGenerationStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[ReportStrategy] Generating report with config: " + job.getConfig());
        connection.execute("INSERT INTO reports (job_id, status) VALUES ('" + job.getId() + "', 'GENERATED')");
        System.out.println("[ReportStrategy] Report generated successfully");
    }
}
