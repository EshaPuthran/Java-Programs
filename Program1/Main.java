package employee;

public class Main {

	public static void main(String[] args) {
		//Creating two Employee objects
		Employee e1=new Employee("Esha",1,10000.0d);
		Employee e2=new Employee("Diya",2,20000.0d);
		
		//displaying initial Details
		System.out.println("Initial Employee Details are:");
		e1.displayDetails();
		e2.displayDetails();
		
		//incrementing the salary
		System.out.println("Updated Employee Details are:");
		e1.increaseSalary(10.0d);
		e2.increaseSalary(20.0d);
		
		// Displaying updated details
		e1.displayDetails();
		e2.displayDetails();


	}

}
