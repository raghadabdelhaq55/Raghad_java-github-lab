package edu.najah.cap.advance.assignments.assignment2;

public class BasicPayload implements Payload {

    private final String content;

    public BasicPayload(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
