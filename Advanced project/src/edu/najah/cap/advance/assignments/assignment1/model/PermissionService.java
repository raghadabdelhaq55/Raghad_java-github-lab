package edu.najah.cap.advance.assignments.assignment1.model;

import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.job.JobType;

public class PermissionService {

    public boolean canExecute(User user, Job job) {
        // مثال بسيط: REPORT يحتاج ADMIN
        if (job.getType() == JobType.REPORT && !"ADMIN".equalsIgnoreCase(user.getRole())) {
            return false;
        }
        return true;
    }
}
