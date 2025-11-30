

import edu.najah.cap.advance.assignments.assignment1.executor.JobManager;
import edu.najah.cap.advance.assignments.assignment1.job.Job;
import edu.najah.cap.advance.assignments.assignment1.job.JobType;
import edu.najah.cap.advance.assignments.assignment1.model.User;
import edu.najah.cap.advance.assignments.assignment1.templates.JobFactory;

import java.util.Scanner;
import java.util.UUID;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        JobManager manager = new JobManager();

        System.out.println("===== TMPS Interactive Console =====");

        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter user role (ADMIN/USER): ");
        String role = scanner.nextLine().trim();

        User user = new User(UUID.randomUUID().toString(), userName, role);

        while (true) {
            System.out.println();
            System.out.println("Choose job type:");
            System.out.println("1 - EMAIL");
            System.out.println("2 - DATA PROCESSING");
            System.out.println("3 - REPORT");
            System.out.println("0 - EXIT");
            System.out.print("Your choice: ");

            String line = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
                continue;
            }

            if (choice == 0) {
                break;
            }

            JobType type;
            switch (choice) {
                case 1:
                    type = JobType.EMAIL;
                    break;
                case 2:
                    type = JobType.DATA_PROCESSING;
                    break;
                case 3:
                    type = JobType.REPORT;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
                    continue;
            }

            Job job = JobFactory.createDefaultJob(type);
            manager.execute(job, user);
        }

        System.out.println("\n=== Application finished ===");
        scanner.close();
    }
}
