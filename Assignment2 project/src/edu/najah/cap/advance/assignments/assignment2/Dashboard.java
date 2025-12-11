package edu.najah.cap.advance.assignments.assignment2;

public class Dashboard implements EventObserver {

    public void updateMetrics(Event e) {
        System.out.println(String.format(
                "[Dashboard] metrics updated for %s, payload: %s",
                e.getId(), e.getPayload()));
    }

    @Override
    public void onEvent(Event event) {
        updateMetrics(event);
    }
}
