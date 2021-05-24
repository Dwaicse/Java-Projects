package com.busticket;

public class BusTicket {
   
	private int ticketNo;
	private float ticketPrice;
	private float totalAmount;
	private Person person;
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void calculateTotal()
	{
	   int age =	person.getAge();
	   char gender = person.getGender();
	   if(age < 16)
	   {
		   this.setTotalAmount((float) (this.getTicketPrice()*0.5));
	   }
	   else if(age>=60)
	   {
		   this.setTotalAmount((float) (this.getTicketPrice()*0.75));
	   }
	   
	   else if(gender=='f'|| gender=='F')
	   {
		   this.setTotalAmount((float) (this.getTicketPrice()*0.90));
	   }
	   
	   else
	   {
		   this.setTotalAmount((float)this.getTicketPrice());
	   }
	}
	
}
