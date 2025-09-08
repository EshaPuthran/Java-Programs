package transport;

public class Drone extends Vehicle implements IPayable {

	public Drone(String id) {
		super(id);
		System.out.println("Drone() constructor called");
	}

	@Override
	public double cost(double distanceKm)
	{
		return 20 * distanceKm ;
	}

	@Override
	public void deliver(String item, String place) {
		if (!SecurityRules.canFly(place) )
		  {
	            System.out.println("Delivery to "+place + " is blocked by security.");
	            return;
	        }
	        System.out.println("Delivering "+item+ " to "+place + " by Drone.");
	}

}
