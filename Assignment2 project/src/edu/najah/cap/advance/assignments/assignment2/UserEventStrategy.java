package edu.najah.cap.advance.assignments.assignment2;

public class UserEventStrategy implements EventProcessingStrategy {

    @Override
    public void process(Event event) {
        System.out.println("[USER] user-specific step for " + event.getId());
    }
}
