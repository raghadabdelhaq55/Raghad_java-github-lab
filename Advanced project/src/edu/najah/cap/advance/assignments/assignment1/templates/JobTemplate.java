package edu.najah.cap.advance.assignments.assignment1.templates;

import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.job.JobType;

import java.util.UUID;

public class JobTemplate {

    private final JobType type;
    private final String name;
    private final String defaultConfig;

    public JobTemplate(JobType type, String name, String defaultConfig) {
        this.type = type;
        this.name = name;
        this.defaultConfig = defaultConfig;
    }

    public Job createJob() {
        String id = UUID.randomUUID().toString();
        return new Job(id, type, name, defaultConfig);
    }
}
