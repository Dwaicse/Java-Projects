package com.busticket;

import java.util.Scanner;

public class Testmain {
	
	

	public static BusTicket getTicketDetails()
	{
		Scanner sc = new Scanner(System.in);
		BusTicket obj  = new BusTicket();
		Person obj1 = new Person();
		System.out.println("Enter the passenger name:");
		obj1.setName(sc.next());
		System.out.println("Enter the gender(M or F / m or f): ");
		obj1.setGender(sc.next().charAt(0));
		System.out.println("Enter the age:");
		obj1.setAge(sc.nextInt());
		System.out.println("Enter ticket no:");
		obj.setTicketNo(sc.nextInt());
		System.out.println("Enter the ticket price:");
		obj.setTicketPrice(sc.nextFloat());
		obj.setPerson(obj1);
		obj.calculateTotal();
		sc.close();
		return obj;
		
		
		
	}
	public static void main(String[] args) {
		BusTicket obj = getTicketDetails();
		System.out.println("Ticket no:"+ obj.getTicketNo());
		System.out.println("Passenger Name:"+ obj.getPerson().getName());
		System.out.println("Price of a ticket:"+ obj.getTicketPrice());
		System.out.println("Total Amount:"+ obj.getTotalAmount());
		
		

	}

}
