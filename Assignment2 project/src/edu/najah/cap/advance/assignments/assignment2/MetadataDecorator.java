package edu.najah.cap.advance.assignments.assignment2;

public class MetadataDecorator extends PayloadDecorator {

    private final String metadata;

    public MetadataDecorator(Payload inner, String metadata) {
        super(inner);
        this.metadata = metadata;
    }

    @Override
    public String getContent() {
        return "META(" + metadata + ")::" + inner.getContent();
    }
}
