package edu.najah.cap.advance.assignments.assignment2;

public class Logger implements EventObserver {

    public void log(Event event) {
        System.out.println("[LOG] Processed event " + event.getId()
                + " type " + event.getType());
    }

    @Override
    public void onEvent(Event event) {
        log(event);
    }
}
