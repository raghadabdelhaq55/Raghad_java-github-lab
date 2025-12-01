package edu.najah.cap.advance.assignments.assignment1.executor;

import edu.najah.cap.advance.assignments.assignment1.job.JobType;

import java.util.EnumMap;
import java.util.Map;

public final class StrategyRegistry {

    private static final Map<JobType, JobStrategy> STRATEGIES =
            new EnumMap<>(JobType.class);

    static {
        STRATEGIES.put(JobType.EMAIL, new EmailJobStrategy());
        STRATEGIES.put(JobType.DATA_PROCESSING, new DataProcessingStrategy());
        STRATEGIES.put(JobType.REPORT, new ReportGenerationStrategy());
    }

    private StrategyRegistry() { }

    public static JobStrategy getStrategy(JobType type) {
        JobStrategy strategy = STRATEGIES.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy for type " + type);
        }
        return strategy;
    }
}
