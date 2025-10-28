package examlogger;
import java.io.IOException;


public class StudentWorker implements Runnable {
	private final Student student;
    private final ResultWriter writer;

    public StudentWorker(Student student, ResultWriter writer) {
        this.student = student;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            writer.write(student);
            System.out.println(Thread.currentThread().getName() + " logged: " + student.toCsv());
        } catch (IOException e) {
            System.err.println("Error writing " + student.getNumber() + ": " + e.getMessage());
        }
    }
}