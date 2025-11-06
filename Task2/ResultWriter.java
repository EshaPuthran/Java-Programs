package examlogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {
	private final BufferedWriter bw;

    public ResultWriter(String filename) throws IOException {
        File file = new File(filename);
        bw = new BufferedWriter(new FileWriter(file, true));
        // Write header only if file is empty
        if (file.length() == 0) {
            bw.write("Name,Number,Marks\n");
            bw.flush();
        }
    }

    // Thread-safe write method
    public synchronized void write(Student student) throws IOException {
        bw.write(student.toCsv() + "\n");
        bw.flush();
    }

    public void close() throws IOException {
        bw.close();
    }
}