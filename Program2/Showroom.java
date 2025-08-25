package cars;

public class Showroom 
{

	public static void main(String[] args)
	{
		
		Cars c1 = new Cars("Ford", "Focus", 20000, 18.5);
        Cars c2 = new Cars("Honda", "Civic", 18000, 14.5, "Esha");
        Cars c3 = new Cars("Hyundai","Elantra", 14000, 11.5);
        
	    c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();
        
        
        // using setter
        c1.setOwnerName("Sheela");  
        c1.updatePrice(25000);
        
      
        // updated details
        System.out.println("After Updating :");
        c1.displayDetails();

        Cars.showShowroomName();
        Cars.showTotalCars();

	}

}
