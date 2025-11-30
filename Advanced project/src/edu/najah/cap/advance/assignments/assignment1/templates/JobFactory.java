package edu.najah.cap.advance.assignments.assignment1.templates;

import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.job.JobType;

import java.util.EnumMap;
import java.util.Map;

public final class JobFactory {

    private static final Map<JobType, JobTemplate> TEMPLATES =
            new EnumMap<>(JobType.class);

    static {
        // نفس فكرة الصورة: Standard Email / Data / Report
        TEMPLATES.put(JobType.EMAIL,
                new JobTemplate(
                        JobType.EMAIL,
                        "Standard Email",
                        "format=HTML;priority=normal"
                ));

        TEMPLATES.put(JobType.DATA_PROCESSING,
                new JobTemplate(
                        JobType.DATA_PROCESSING,
                        "Daily Data Processing",
                        "source=DB;mode=batch"
                ));

        TEMPLATES.put(JobType.REPORT,
                new JobTemplate(
                        JobType.REPORT,
                        "Monthly Report",
                        "template=FINANCE;format=PDF"
                ));
    }

    private JobFactory() { }

    public static Job createDefaultJob(JobType type) {
        JobTemplate template = TEMPLATES.get(type);
        if (template == null) {
            throw new IllegalArgumentException("No template for type " + type);
        }
        return template.createJob();
    }
}
