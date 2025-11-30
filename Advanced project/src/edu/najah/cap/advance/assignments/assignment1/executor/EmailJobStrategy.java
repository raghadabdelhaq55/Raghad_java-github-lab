package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.job.Job;

public class EmailJobStrategy implements JobStrategy {

    @Override
    public void execute(Job job, Connection connection) {
        System.out.println("[EmailStrategy] Preparing to send email using config: " + job.getConfig());
        connection.execute("INSERT INTO email_sent (job, status) VALUES ('" + job.getId() + "', 'SENT')");
        System.out.println("[EmailStrategy] Email sent successfully");
    }
}
