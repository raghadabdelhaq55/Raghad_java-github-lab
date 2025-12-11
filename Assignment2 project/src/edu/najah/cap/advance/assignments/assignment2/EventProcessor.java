package edu.najah.cap.advance.assignments.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventProcessor {

    private final Database database;
    private final EventTransformer transformer;
    private final Map<EventType, EventProcessingStrategy> strategies = new HashMap<>();
    private final List<EventObserver> observers = new ArrayList<>();

    public EventProcessor(Database database,
                          Dashboard dashboard,
                          Logger logger,
                          EventTransformer transformer) {

        this.database = database;
        this.transformer = transformer;

        // Observer pattern: سجّل المراقبين
        addObserver(dashboard);
        addObserver(logger);

        // Strategy pattern: حسب نوع الـ event
        strategies.put(EventType.SECURITY, new SecurityEventStrategy());
        strategies.put(EventType.USER, new UserEventStrategy());
        strategies.put(EventType.SYSTEM, new SystemEventStrategy());
        strategies.put(EventType.DEFAULT, new DefaultEventStrategy());
    }

    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Event event) {
        for (EventObserver observer : observers) {
            observer.onEvent(event);
        }
    }

    public void process(Event event) {

        System.out.println("\n========================================");
        System.out.println("Processing NEW EVENT");
        System.out.println("Type: " + event.getType());
        System.out.println("Payload: " + event.getPayload());
        System.out.println("----------------------------------------");

        if (!isValid(event)) {
            System.out.println("Invalid event");
            return;
        }

        // Prototype: نشتغل على نسخة
        Event workingCopy = event.copy();

        // Template Method (داخل transformer)
        String data = transformer.transform(workingCopy);

        // generate ID قبل الإشعار
        String id = generateId(data);
        workingCopy.setId(id);
        event.setId(id);

        // Observer: notify all observers
        notifyObservers(workingCopy);
        System.out.println("----------------------------------------");

        // عرض البيانات بعد التحويل
        System.out.println("TRANSFORMED DATA:");
        System.out.println(data);
        System.out.println("----------------------------------------");

        // Proxy + Connection Pool يتنفذوا داخل database.save()
        database.save(workingCopy.getId(), data);
        System.out.println("----------------------------------------");

        // Strategy: حسب نوع الـ event
        EventProcessingStrategy strategy =
                strategies.getOrDefault(workingCopy.getType(), strategies.get(EventType.DEFAULT));

        System.out.println(workingCopy.getType() + " STRATEGY:");
        strategy.process(workingCopy);

        System.out.println("========================================\n");
    }

    private boolean isValid(Event e) {
        return e.getPayload() != null && !e.getPayload().isEmpty();
    }

    private String generateId(String data) {
        return System.currentTimeMillis() + "-" + Math.abs(data.hashCode());
    }
}
