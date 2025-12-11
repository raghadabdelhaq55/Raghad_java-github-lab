package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.connections.Connection;
import edu.najah.cap.advance.assignments.assignment1.connections.ConnectionPool;
import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.model.Logger;
import edu.najah.cap.advance.assignments.assignment1.model.PermissionService;
import edu.najah.cap.advance.assignments.assignment1.model.User;

public class JobManager {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final Logger logger = new Logger();
    private final PermissionService permissionService = new PermissionService();

    public void execute(Job job, User user) {

        // Permission
        if (!permissionService.canExecute(user, job)) {
            String msg = "[Proxy] Permission denied: User '" + user.getName()
                    + "' does not have permission for job type '" + job.getType() + "'";
            logger.log(msg);
            return;
        }

        logger.log("[Proxy] Permission validated for user '" + user.getName()
                + "' on job type '" + job.getType() + "'");

        logger.log("[Proxy] ===== JOB START =====");
        logger.log("[Proxy] Job ID: " + job.getId());
        logger.log("[Proxy] Job Name: " + job.getName());
        logger.log("[Proxy] Job Type: " + job.getType());
        logger.log("[Proxy] Requested By: " + user.getName());

        Connection connection = connectionPool.acquire();
        long start = System.currentTimeMillis();

        try {
            logger.log("[RefactoredExecutor] Executing job " + job.getName()
                    + " (" + job.getType() + ")");
            job.executeWithStrategy(connection);
        } finally {
            long end = System.currentTimeMillis();
            connectionPool.release(connection);
            logger.log("[Proxy] ===== JOB COMPLETE =====");
            logger.log("[Proxy] Job '" + job.getName()
                    + "' completed successfully");
            logger.log("[Proxy] Execution time: " + (end - start) + " ms");
        }
    }
}
