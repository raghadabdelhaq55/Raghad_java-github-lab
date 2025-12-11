package edu.najah.cap.advance.assignments.assignment2;

public class App {

    public static void main(String[] args) {

        // Connection Pool + Proxy
        DbConnectionPool pool = new DbConnectionPool(2);
        Database database = new DatabaseProxy(pool);

        // Observers
        Dashboard dashboard = new Dashboard();
        Logger logger = new Logger();

        // Template Method + Decorator
        EventTransformer transformer = new FlagBasedEventTransformer();

        // EventProcessor (Subject + Strategy + يستخدم كل الباترنز)
        EventProcessor eventProcessor =
                new EventProcessor(database, dashboard, logger, transformer);

        // --------- First event (USER) ----------
        Event e1 = new Event(EventType.USER, "user-click");
        e1.setEncrypt(true);
        e1.setAddMetadata(true);
        e1.setMetadata("u=42");
        eventProcessor.process(e1);

        // --------- Second event (SECURITY) ----------
        Event e2 = new Event(EventType.SECURITY, "failed-login");
        e2.setCompress(true);
        eventProcessor.process(e2);
    }
}
