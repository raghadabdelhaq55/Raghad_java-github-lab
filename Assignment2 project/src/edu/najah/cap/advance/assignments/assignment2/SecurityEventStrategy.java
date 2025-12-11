package edu.najah.cap.advance.assignments.assignment2;

public class SecurityEventStrategy implements EventProcessingStrategy {

    @Override
    public void process(Event event) {
        System.out.println("[SECURITY] extra analysis for " + event.getId());
        System.out.println("[SecurityMonitor] alert for " + event.getId());
    }
}
