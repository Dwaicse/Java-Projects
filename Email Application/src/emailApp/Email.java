package emailApp;

import java.util.Scanner;

public class Email {

	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	private String companySuffix = "dwai.com";
	
	public Email(String firstname, String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = setDepartment();
		this.password = randomPassword(defaultPasswordLength);
		//System.out.println("Your Deparment is: "+this.department);
		String email = firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department.toLowerCase()+"."+companySuffix;
		this.email = email;
		//System.out.println("Your Email is: "+ email);
		//System.out.println("Your Password is: "+ this.password);
		
		
	
		
	}
	
//--------------------------------------------------------------------------------------------------------------------------	
	

//For Setting Department 

public String setDepartment() {
	 System.out.println("DEPARTMENT CODE\nEnter the department\n 1. for Sales\n2. for Development\n3. for Accounting\n0 for none\n Enter your department code:");
	 Scanner in = new Scanner(System.in);
	  int depChoice =  in.nextInt();
	  if(depChoice==1)
	  {
		  return "Sales";
	  }
	  else if(depChoice == 2)
	  {
		    return "Development";
	  }
	  else if(depChoice==3)
	  {
		  return "Accounting";
	  }
	  else {
		  return "";
	  }
}
//--------------------------------------------------------------------------------------------------------------------------------
// For Generating Random Password

private String randomPassword(int length) {
       
	   String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
	   char[] password = new char[length];
	   for(int i=0; i<length ; i++)
	   {
		   int rand = (int) (Math.random()*passwordSet.length());
		   password[i] = passwordSet.charAt(rand);
	   }
	   
	   return new String(password);
	
}


// Set MailBox Capacity

   public void setMailboxCapacity(int capacity) {
	   this.mailBoxCapacity = capacity;
   }
   
   public void setAlternateEmail(String altEmail) {
	     this.alternateEmail = altEmail;
   }
   
   public void changePassword(String password) {
	   this.password = password;
   }
   
   public int getMailboxCapacity()
   {
	    return mailBoxCapacity;
   }

    public String getAlternateEmail()
    {
    	return alternateEmail;
    }
    
    public String showInfo() {
    	return "Display Name: " + firstname+" "+lastname +"\n"+
                    "Company Email: "+ email +"\n"+
    			   "Password: "+ password +"\n"+
                    "Mailbox Capacity: "+ mailBoxCapacity+ "mb" ;
    			    
    }
   
   
}