import java.util.Scanner;

public class StaticQueue {
	
	public static int queue[]=new int[5];
	public static int rear=-1;	//rear==last index q is full
	public static int front=0;  //front>rear means q is empty
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {


		do
		{
		System.out.println("**** QUEUE MENU ****");
		System.out.println("1. INSERT");
		System.out.println("2. DELETE");
		System.out.println("3. DISPLAY");
		System.out.println("4. EXIT");
		System.out.println("Please enter your choice");
		int choice=sc.nextInt();

		switch(choice)
		{
		case 1: insert(); break;
		case 2: delete(); break;
		case 3: display(); break;
		case 4 : System.exit(0);
		default : System.out.println("Please enter valid input");
		}
		}while(true);
	}

	private static void display() {
		for (int i = front; i <=rear; i++) {
			System.out.println(queue[i]);
		}

	}

	private static void delete() {
		int data;
		if(front>rear)
		{
			System.out.println("QUEUE IS EMPTY");
		}
		else
		{
			data=queue[front];
			front++;
			System.out.println(data + "has been Removed");	
		}

	}

	private static void insert() {
		int data;
		if(rear==4)
		{
			System.out.println("QUEUE IS FULL");
		}
		else
		{
			System.out.println("Enter Data to Insert");
			data=sc.nextInt();
			rear++;
			queue[rear]=data;
		}

	}

}
