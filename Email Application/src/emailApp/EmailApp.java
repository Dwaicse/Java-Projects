package emailApp;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE NUMBER OF EMAILS YOU WANT TO CREATE: ");
		int number = sc.nextInt();
		Email [] em = new Email[number];
		for(int i=0;i<number;i++)
		{
	    System.out.println("ENTER"+" " + (i+1)+" "+ "NUMBER DETAILS");
		System.out.println("ENTER YOUR FIRST NAME:");
        String firstName = sc.next();
        sc.nextLine();
		System.out.println("ENTER YOUR LAST NAME:");
	    String lastName = sc.next();
	    sc.nextLine();
		Email em1 = new Email(firstName , lastName ); 
		em[i] = em1;
	}
		
	System.out.println("\n\nEmails Generated Successfully!\n\n\n Emails Details :\n\n");
	
	for(int i=0;i<number;i++)
	{
      System.out.println("Record Details"+" "+(i+1)+" :\n\n"+em[i].showInfo()+"\n\n");
	

}
	
		

}
}
