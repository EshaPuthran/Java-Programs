package examlogger;


	import static org.junit.jupiter.api.Assertions.*;
	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.util.*;
	import org.junit.jupiter.api.*;

	class ExamLoggerIntegrationTest {
	    private File testFile;
	    private ResultWriter writer;

	    @BeforeEach
	    void setUp() throws IOException {
	        testFile = File.createTempFile("testScores", ".csv");
	        writer = new ResultWriter(testFile.getAbsolutePath());
	    }

	    @AfterEach
	    void tearDown() throws IOException {
	        if (writer != null) {
	            try {
	                writer.close();
	            } catch (IOException ignored) {}
	        }
	        if (testFile.exists()) {
	            testFile.delete();
	        }
	    }

	    //Success Case 1: File Initialization Test
	    @Test
	    @DisplayName("Test 1: Header should be written correctly on creation")
	    void testHeaderIsWritten() throws IOException {
	        List<String> lines = Files.readAllLines(testFile.toPath());
	        assertFalse(lines.isEmpty(), "File should not be empty after initialization");
	        assertEquals("Name,Number,Marks", lines.get(0).trim(), "Header should be written correctly");
	    }

	    //Success Case 2: Basic File Write Test
	    @Test
	    @DisplayName("Test 2: Single student record should be written correctly")
	    void testSingleWrite() throws IOException {
	        Student s = new Student("TestUser", "T01", 90);
	        writer.write(s);

	        List<String> lines = Files.readAllLines(testFile.toPath());
	        assertEquals(2, lines.size(), "Should contain header and one student entry");
	        assertEquals("TestUser,T01,90", lines.get(1).trim(), "Student record should match");
	    }

	    //Success Case 3: Multi-Threaded Test (Thread Safety & Completion)
	    @Test
	    @DisplayName("Test 3: Multiple threads should complete and write all records safely (Thread-Safety Check)")
	    void testThreadSafetyAndCompletion() throws IOException, InterruptedException {
	        List<Student> students = List.of(
	            new Student("Ram", "CS01", 95),
	            new Student("Seetha", "CS02", 90),
	            new Student("Gita", "CS03", 85),
	            new Student("Krish", "CS04", 75)
	        );

	        List<Thread> threads = new ArrayList<>();
	        for (Student s : students) {
	            Thread t = new Thread(new StudentWorker(s, writer), "Student-" + s.getNumber());
	            threads.add(t);
	            t.start();
	        }

	        for (Thread t : threads) {
	            t.join();
	            assertFalse(t.isAlive(), "Thread " + t.getName() + " should finish");
	        }

	        List<String> lines = Files.readAllLines(testFile.toPath());
	        assertEquals(1 + students.size(), lines.size(), "All students must be written (header + 4 records)");

	        String fileContent = String.join(",", lines);
	        for (Student s : students) {
	            assertTrue(fileContent.contains(s.getNumber()), "File should contain roll number " + s.getNumber());
	        }
	    }

	    //Failure Case: Writing to Closed File (But handled by an exception)
	    @Test
	    @DisplayName("Test 4: Fail Case - Should throw IOException when writing to a closed file")
	    void testWriteToClosedFileThrowsException() throws IOException {
	        Student s = new Student("FailUser", "F01", 50);

	       	        writer.close();

	        
	        assertThrows(IOException.class, () -> {
	            writer.write(s);
	        }, "Writing to a closed ResultWriter should throw an IOException");
	    }
	}