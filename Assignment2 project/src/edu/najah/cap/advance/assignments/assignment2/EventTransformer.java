package edu.najah.cap.advance.assignments.assignment2;

// Template Method pattern
public abstract class EventTransformer {

    // خوارزمية ثابتة (template)
    public final String transform(Event event) {
        String data = readPayload(event);
        data = applyEncryption(event, data);
        data = applyCompression(event, data);
        data = applyMetadata(event, data);
        return data;
    }

    protected String readPayload(Event event) {
        return event.getPayload();
    }


    protected String applyEncryption(Event event, String data) {
        return data;
    }

    protected String applyCompression(Event event, String data) {
        return data;
    }

    protected String applyMetadata(Event event, String data) {
        return data;
    }
}
