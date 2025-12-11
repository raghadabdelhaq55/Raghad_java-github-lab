package edu.najah.cap.advance.assignments.assignment2;

// Concrete Template + تستخدم Decorators
public class FlagBasedEventTransformer extends EventTransformer {

    @Override
    protected String applyEncryption(Event e, String data) {
        if (!e.isEncrypt()) {
            return data;
        }
        Payload payload = new EncryptDecorator(new BasicPayload(data));
        return payload.getContent();
    }

    @Override
    protected String applyCompression(Event e, String data) {
        if (!e.isCompress()) {
            return data;
        }
        Payload payload = new CompressDecorator(new BasicPayload(data));
        return payload.getContent();
    }

    @Override
    protected String applyMetadata(Event e, String data) {
        if (!e.isAddMetadata()) {
            return data;
        }
        Payload payload = new MetadataDecorator(new BasicPayload(data), e.getMetadata());
        return payload.getContent();
    }
}
