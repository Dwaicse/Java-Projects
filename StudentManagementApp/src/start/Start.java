package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;

import studentDao.StudentDao;



public class Start {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to Student Management System!");
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true)
		{
			System.out.println("PRESS 1 to ADD Student");
			System.out.println("PRESS 2 to DELETE Student");
			System.out.println("PRESS 3 to Display Student");
			System.out.println("PRESS 4 to Exit App");
			
			int c = Integer.parseInt(bReader.readLine());
			
			if(c==1)
			{
				//Add Student
				System.out.println("Enter user name :");
				String nameString = bReader.readLine();
				
				System.out.println("Enter user phone :");
				String phoneString = bReader.readLine();
				
				System.out.println("Enter user city :");
				String cityString = bReader.readLine();
				
				Student student = new Student(nameString,phoneString,cityString);
				
		        boolean answer = StudentDao.insertStudentToDB(student);
		        
		        if(answer)
		        {
		        	System.out.println("Student is added successfully!! ");
		        }else {
					System.out.println("Something Went Wrong!");
				}
				
				System.out.println(student);
				
				
				
				
			}else if(c==2)
			{
				//Delete Student
				
				System.out.println("Enter student id to delete: ");
				int userId = Integer.parseInt(bReader.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if(f)
				{
					System.out.println("User Deleted Successfully!");
				}
				else {
					System.out.println("Something went wrong!");
				}
				
				
				
				
			}else if (c==3) 
			{
				
			   StudentDao.showAllStudent();
			     
			}
			else if (c==4) 
			{
				
				break;
			     
			}
			
		}
		
		System.out.println("Thank You For Using My Application !!");
		System.out.println("See You Soon Bye Bye !!");

	}
	
	
	

}
