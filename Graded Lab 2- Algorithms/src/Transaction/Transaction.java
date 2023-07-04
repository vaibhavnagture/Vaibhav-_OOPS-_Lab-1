package Transaction;

import java.util.Scanner;


public class Transaction {

	public static void main(String[] args) {
		
		int nod;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of days shop was open");  //5
		nod=sc.nextInt();										   // 0		 1		 2		 3       4
		System.out.println("Enter the earnings for "+nod+ "days"); //100	200		300		400		500
		int earnings[]=new int[nod];
		for(int i=0;i<nod;i++)
		{
			earnings[i]=sc.nextInt();
		}

		System.out.println("Enter Number of targets");		//3
		int targets=sc.nextInt();


		for(int i=1;i<=targets;i++)
		{
			System.out.println("Please enter target "+ i);		//350
			int target=sc.nextInt();

			int flag=0; //target not acheived
			int sum=0;

				for(int j=0;j<earnings.length;j++)
				{
					sum=sum+earnings[j];
					if(sum>=target)
					{
						flag=1;  //target acheived
						System.out.println("Target Achieved on day "+ (j+1));
						break;
					}
				}

					if(flag==0)
						System.out.println("Target Not Achieved");	


		}



	}

}
