package employee;

public class Employee {
	//Data members are
			String name;
			int id;
			double salary;
	public Employee(String n,int id,double sal)
		{
		name=n;
		this.id=id;
		this.salary=sal;
		}
	public	void displayDetails()
		{
			System.out.println("Employee ID:"+this.id);
			System.out.println("Your name is:"+name);
			System.out.println("Your Salary is"+salary);
		}
		void increaseSalary(double percentage)
		{
			salary+=(salary*percentage)/100.0d;
			
		}

}
