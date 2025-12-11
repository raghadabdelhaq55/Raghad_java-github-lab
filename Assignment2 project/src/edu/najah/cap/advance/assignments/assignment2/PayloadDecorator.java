package edu.najah.cap.advance.assignments.assignment2;

public abstract class PayloadDecorator implements Payload {

    protected final Payload inner;

    protected PayloadDecorator(Payload inner) {
        this.inner = inner;
    }
}
