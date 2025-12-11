package edu.najah.cap.advance.assignments.assignment2;

public class SystemEventStrategy implements EventProcessingStrategy {

    @Override
    public void process(Event event) {
        System.out.println("[SYSTEM] system audit log " + event.getId());
    }
}
