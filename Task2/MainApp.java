package examlogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainApp {
    public static void main(String[] args) throws IOException, InterruptedException {
    	ResultWriter writer;

        try {
            writer = new ResultWriter("exam_scores.csv");
        } catch (IOException e) {
            System.err.println("Failed to create CSV file: " + e.getMessage());
            return;
        }

        List<Student> students = new ArrayList<>();
        students.add(new Student("Esha", "IS01", 95));
        students.add(new Student("Jia", "IS02", 90));
        students.add(new Student("Disha", "IS03", 78));
        students.add(new Student("Sheela", "IS04", 92));

        System.out.println("\nStarting submissions\n");

        List<Thread> threads = new ArrayList<>();
        for (Student s : students) {
            Thread t = new Thread(new StudentWorker(s, writer), "Student-" + s.getNumber());
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join(); // ensure all threads finish
        }

        System.out.println("\nAll student records are saved successfully");

        writer.close();
    }
}