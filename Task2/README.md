Student Exam Score Logger
This Java program simulates multiple students submitting their exam scores at the same time using  threads.
Scores are safely written to a shared CSV file using synchronized file writing to ensure thread safety.

Demonstrates
- Multiple threads writing concurrently  
- Thread-safe file writing using `synchronized` methods  
- Storing student data (Name, Roll Number, Marks) in a CSV file  
- JUnit tests verifying file writing and thread completion
Files Overview
•	‘Student.java’ -> Represents a student record (name, roll number, marks) 
•	“ResultWriter.java” -> Handles thread-safe writing to a CSV file 
•	“StudentWorker.java” -> Implements “Runnable”, simulating each student submitting a score 
•	“MainApp.java” ->Main class that starts and coordinates all student threads 
•	“ResultWriterTest.java” ->JUnit tests verifying file writing and content correctness 
•	“ThreadTest.java” -> JUnit tests verifying multi-threaded writing and thread completion 
Program Output
Starting submissions

Student-IS02 logged: Jia,IS02,90
Student-IS01 logged: Esha,IS01,95
Student-IS04 logged: Sheela,IS04,92
Student-IS03 logged: Disha,IS03,78

All student records are saved successfully
JUnit Results:
Student-CS01 logged: Ram,CS01,95
Student-CS02 logged: Seetha,CS02,90


