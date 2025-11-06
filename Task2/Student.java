package examlogger;

public class Student{
	

    private final String name;
    private final String number;
    private final int marks;

    public Student(String name, String number, int marks) {
        this.name = name;
        this.number = number;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getMarks() {
        return marks;
    }

    public String toCsv() {
        return name + "," + number + "," + marks;
    }
}
