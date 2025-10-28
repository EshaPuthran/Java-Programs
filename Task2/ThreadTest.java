package examlogger;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import org.junit.jupiter.api.Test;

class ThreadTest {
	 @Test
	    void threadsShouldCompleteAndWriteAll() throws IOException, InterruptedException {
	        File temp = File.createTempFile("examThread", ".csv");
	        ResultWriter writer = new ResultWriter(temp.getAbsolutePath());

	        try {
	            List<Student> students = List.of(
	                new Student("Ram", "CS01", 95),
	                new Student("Seetha", "CS02", 90)
	            );

	            List<Thread> threads = new ArrayList<>();
	            for (Student s : students) {
	                Thread t = new Thread(new StudentWorker(s, writer), "Student-" + s.getNumber());
	                threads.add(t);
	                t.start();
	            }

	            for (Thread t : threads) {
	                t.join(); // ensure threads finish
	                assertFalse(t.isAlive(), "Thread should finish");
	            }

	            List<String> lines = Files.readAllLines(temp.toPath());
	            assertEquals(1 + students.size(), lines.size(), "All students must be written");

	            String fileContent = String.join(",", lines);
	            for (Student s : students) {
	                assertTrue(fileContent.contains(s.getNumber()), "File should contain number " + s.getNumber());
	            }
	        } finally {
	            writer.close();
	            temp.delete();
	        }
	    }
	}
