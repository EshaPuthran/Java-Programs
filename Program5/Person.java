package ticketCounter;
//person class
public class Person {
	private String name;
    private int age;
    private Gender gender;
//assigning  fields
    Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    void displayPerson() {
        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }

}
