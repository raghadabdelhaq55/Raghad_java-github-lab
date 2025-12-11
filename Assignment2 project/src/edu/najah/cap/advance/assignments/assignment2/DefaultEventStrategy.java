package edu.najah.cap.advance.assignments.assignment2;

public class DefaultEventStrategy implements EventProcessingStrategy {

    @Override
    public void process(Event event) {
        //   بس عشان لو نوع جديد وما نسيناه
        System.out.println("[DEFAULT] no specific handler for type " + event.getType());
    }
}
