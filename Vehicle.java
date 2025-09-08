package transport;

public abstract class Vehicle {
	protected String id;

    public Vehicle(String id) 
    {
       
        System.out.println("Vehicle() constructor called");
    }

    //abstract method  
    public abstract void deliver(String item, String place);


}
