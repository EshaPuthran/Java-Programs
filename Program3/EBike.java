package transport;

public class EBike extends Bicycle {
	private int battery;

	public EBike(String id,int battery) 
	{
		super(id);
		this.battery = battery;
        System.out.println("EBike() constructor called");
	}
	@Override
    public void deliver (String item, String place) 
	{
        System.out.println("Checking battery: " +battery+ "%");
        
        super.deliver(item, place);
}
}
