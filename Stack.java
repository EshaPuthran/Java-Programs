package Stack;

public class Stack {
	private int arr[];
	private int top;
	private int capacity;

	Stack(int size) 
	{
		capacity=size;
		arr= new int[capacity];
		top=-1;
	}
	Stack(int[] inputArray)
	{
		capacity=inputArray.length;
		arr=new int[capacity];
		for(int i=0;i<capacity;i++)
		{
			arr[i]=inputArray[i];
		}
		top=capacity-1;
	}
	void push(int x) 
	{
		if(top >= capacity-1)
		{
			System.out.println("Stack is full or overflow");
			return;
		}
		arr[++top]=x;
		System.out.println("Element "+ x + " is pushed into the stack");
	}
	void push(int x, int y)
	{
		push(x);
		push(y);	
	}
	int pop()
	{
		if (top==-1)
		{
			System.out.println("Stack is empty or underflow");
	            return -1;
		}
		return arr[top--];
	}
	void pop(int n)
	{
		if(n <= 0)
		{
			System.out.println("Invalid input");
			return;
		}
		for(int i=0;i<n;i++)
		{
			int val=pop();
			if(val == -1)
			{
				break;
			}
			System.out.println("Popped element is"+val);
		}
	}
	void display()
	{
		if(top==-1)
		{
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Stack contents are");
		for(int i=top;i>=0;i--)
		{
			System.out.println(arr[i]);
			
		}
	}
	void display(int n)
	{
		if(top==-1)
		{
			System.out.println("Stack is empty");
			return;
		}
	if(n <= 0)
		{
			System.out.println("Invalid input");
			return;
		}
	System.out.println("Top" + n+ "elemets are :");
		for(int i=top;i>=0 && i>top-n;i--)
		{
			System.out.println(arr[i]);
		}
	}
}
