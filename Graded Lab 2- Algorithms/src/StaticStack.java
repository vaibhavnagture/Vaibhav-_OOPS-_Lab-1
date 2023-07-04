import java.util.Scanner;

public class StaticStack {
	
	public static int stack[]=new int[5];
	public static int top=-1;
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {


		do
		{
		System.out.println("**** STACK MENU");
		System.out.println("1. PUSH");
		System.out.println("2. POP");
		System.out.println("3. DISPLAY");
		System.out.println("4. EXIT");
		System.out.println("Please enter your choice");
		int choice=sc.nextInt();

		switch(choice)
		{
		case 1: push(); break;
		case 2: pop(); break;
		case 3: display(); break;
		case 4 : System.exit(0);
		default : System.out.println("Please enter valid input");
		}
		}while(true);
	}

	private static void display() {
		for (int i = top; i >=0; i--) {
			System.out.println(stack[i]);
		}

	}

	private static void pop() {
		int data;
		if(top==-1)
		{
			System.out.println("STACK IS EMPTY");
		}
		else
		{
			data=stack[top];
			top--;
			System.out.println(data + "has been popped");	
		}

	}

	private static void push() {
		int data;
		if(top==4)
		{
			System.out.println("STACK IS FULL");
		}
		else
		{
			System.out.println("Enter Data to Push");
			data=sc.nextInt();
			top++;
			stack[top]=data;
		}


}
	
}
