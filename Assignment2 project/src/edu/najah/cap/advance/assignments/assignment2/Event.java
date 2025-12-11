package edu.najah.cap.advance.assignments.assignment2;

public class  Event {

    private EventType type;      // USER, SYSTEM, SECURITY
    private String payload;
    private boolean encrypt;
    private boolean compress;
    private boolean addMetadata;
    private String metadata;
    private String id;

    public Event(EventType type, String payload) {
        this.type = type;
        this.payload = payload;
    }

    // --- Prototype: copy constructor ---
    private Event(Event other) {
        this.type = other.type;
        this.payload = other.payload;
        this.encrypt = other.encrypt;
        this.compress = other.compress;
        this.addMetadata = other.addMetadata;
        this.metadata = other.metadata;
        this.id = other.id;
    }

    public Event copy() {
        return new Event(this);
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public boolean isCompress() {
        return compress;
    }

    public void setCompress(boolean compress) {
        this.compress = compress;
    }

    public boolean isAddMetadata() {
        return addMetadata;
    }

    public void setAddMetadata(boolean addMetadata) {
        this.addMetadata = addMetadata;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
