package findfactorialsum;

import java.util.Scanner;

public class FindFactorialSum {
	
	public static int calculateFactorial(int a)
	{
		while(a>1)
		{
			return a*calculateFactorial(a-1);
		}
		return 1;
	}

   
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array:");
		int size = sc.nextInt();
		int sum = 0;
		int[] arr = new int[size];
		System.out.println("Enter the elements:");
		for(int i=0; i<size;i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i]>0 && arr[i]<10)
			{
				sum = sum+ calculateFactorial(arr[i]);
			}
			
		}
		
		System.out.println(sum);
        sc.close();
	}

}
