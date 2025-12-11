package edu.najah.cap.advance.assignments.assignment2;

public class CompressDecorator extends PayloadDecorator {

    public CompressDecorator(Payload inner) {
        super(inner);
    }

    @Override
    public String getContent() {
        return "CMP(" + inner.getContent() + ")";
    }
}
