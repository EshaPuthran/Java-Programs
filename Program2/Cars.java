package cars;

public class Cars 
{
	//instance members
	private String brand;   
	private String model;   
	private double price;   
	private double mileage;   
	private String ownerName;   
	 
	 // static members
	 private static int totalCars;           
	 private static String showroomName = "City Motors";  
	 
	    
	 // constructor 1
	 public Cars(String b, String m, double p, double mil) 
	    {
	
	  // initializiation 
	    	brand=b;
	        model=m;
	        this.price=p;
	        this.mileage=mil;
	        ownerName = "Not Assigned";
	        totalCars++;
	}
	 
	 // constructor 2 (overloaded)
	 
	 public Cars(String b, String m, double p, double mil, String owner) 
	    {
		 brand=b;
	     model=m;
	     this.price=p;
	     this.mileage=mil;
	     this.ownerName = owner;
	     totalCars++;
	    }
	 
	 
	 // getter and setter for ownerName
	 
	 public String getOwnerName() 
	 {
	        return ownerName;    
	 }
	    public void setOwnerName(String owner)
	    {
	         ownerName= owner;
	    }
	    
	    // instance method displaying details
	    public void displayDetails()
	    {
	        System.out.println("Brand: " +brand);
	        System.out.println("Model: " +model);
	        System.out.println("Price: " +price);
	        System.out.println("Mileage: " +mileage);
	        System.out.println("Owner: " +ownerName);
	    }
	    
	    public void updatePrice(double newPrice) 
	        {
	            this.price = newPrice;
	         }
	    
	    // static methods
	        public static void showTotalCars() 
	        {
	            System.out.println("Total Cars: " +totalCars );
	        }
	        public static void showShowroomName() 
	        {
	            System.out.println("Showroom: " + showroomName);
	        }
	    }
	    



	    




	


