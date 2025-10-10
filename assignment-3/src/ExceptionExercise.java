public class ExceptionExercise {

    public static void main(String[] args) {
        SimpleConnection connection = new SimpleConnection();

        // 1. Handle exceptions when connecting
        try {
            connection.connect("abc"); // Try changing this value
        } catch (IllegalArgumentException e) {  // Unchecked exception
            System.err.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (Exception e) {  // Checked or general exception
            System.err.println("Caught general Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
            try {
                connection.close();  // Checked exception
            } catch (Exception e) {
                System.err.println("Exception while closing: " + e.getMessage());
            }
        }

        System.out.println("Program continues after exception handling.");
    }

    static class SimpleConnection implements AutoCloseable {

        public void connect(String url) throws Exception {
            System.out.println("Connecting to: " + url);

            if ("invalid".equals(url)) {
                // Throwing an unchecked exception
                throw new IllegalArgumentException("URL cannot be 'invalid'");
            }

            if ("error".equals(url)) {
                // Throwing a checked exception
                throw new Exception("General connection error");
            }

            System.out.println("Connection successful");
        }

        public void testChecked() throws Exception {
            System.out.println("Testing checked exception...");
            throw new Exception("This is a test checked exception");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Closing connection...");
        }
    }
}