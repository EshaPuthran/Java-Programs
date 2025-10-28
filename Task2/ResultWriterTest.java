package examlogger;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.*;

class ResultWriterTest {
	 private File testFile;
	    private ResultWriter writer;

	    @BeforeEach
	    void setUp() throws IOException {
	        testFile = File.createTempFile("testScores", ".csv");
	        writer = new ResultWriter(testFile.getAbsolutePath());
	    }

	    @AfterEach
	    void tearDown() throws IOException {
	        if (writer != null) writer.close();
	        if (testFile.exists()) testFile.delete();
	    }

	    @Test
	    @DisplayName("Header should be written correctly")
	    void testHeaderIsWritten() throws IOException {
	        List<String> lines = Files.readAllLines(testFile.toPath());
	        assertFalse(lines.isEmpty(), "File should not be empty");
	        assertTrue(lines.get(0).startsWith("Name,Number,Marks"), "Header should be written correctly");
	    }

	    @Test
	    @DisplayName("Single student record should be written correctly")
	    void testSingleWrite() throws IOException {
	        Student s = new Student("TestUser", "T01", 90);
	        writer.write(s);

	        List<String> lines = Files.readAllLines(testFile.toPath());
	        assertEquals(2, lines.size());
	        assertTrue(lines.get(1).contains("T01"));
	    }

	    @Test
	    @DisplayName("Multiple student records should be written correctly")
	    void testMultipleWrites() throws IOException {
	        Student s1 = new Student("A", "R1", 80);
	        Student s2 = new Student("B", "R2", 70);

	        writer.write(s1);
	        writer.write(s2);

	        List<String> lines = Files.readAllLines(testFile.toPath());
	        assertEquals(3, lines.size(), "Should contain header + 2 student entries");
	        assertTrue(lines.get(1).contains("R1"));
	        assertTrue(lines.get(2).contains("R2"));
	    }
	}