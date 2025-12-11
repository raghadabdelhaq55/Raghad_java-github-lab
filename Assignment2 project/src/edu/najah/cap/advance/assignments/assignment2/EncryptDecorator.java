package edu.najah.cap.advance.assignments.assignment2;

public class EncryptDecorator extends PayloadDecorator {

    public EncryptDecorator(Payload inner) {
        super(inner);
    }

    @Override
    public String getContent() {
        return "ENC(" + inner.getContent() + ")";
    }
}
