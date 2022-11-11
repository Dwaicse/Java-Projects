package studentDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.student.manage.Student;

import connectionprovider.CP;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student student) {
		
		boolean f =false;
		
		try {
			
			//jdbc code
			Connection connection = CP.createConnection();
			String qString = "insert into students(sname, sphone, scity) values(?,?,?)";
			
			
			//PreparedStatement
			
			PreparedStatement pstmtPreparedStatement = connection.prepareStatement(qString);
           	//Set the Value of Parameter
			pstmtPreparedStatement.setString(1, student.getStudentName());
			pstmtPreparedStatement.setString(2, student.getStudentPhone());
			pstmtPreparedStatement.setString(3, student.getStudentCity());
			
			//Execute
			pstmtPreparedStatement.executeUpdate();
			
			f=true;
			
			
		} catch (Exception e) {
            
			e.printStackTrace();
		}
		
		
		return f;
		
		
	}

	public static boolean deleteStudent(int userId) {
		
		
	boolean f =false;
		
		try {
			
			//jdbc code
			Connection connection = CP.createConnection();
			String qString = "delete from student where sid=?";
			
			
			
			
			//PreparedStatement
			
			PreparedStatement pstmtPreparedStatement = connection.prepareStatement(qString);
           	//Set the Value of Parameter
			pstmtPreparedStatement.setInt(1, userId);
			
			
			//Execute
			pstmtPreparedStatement.executeUpdate();
			
			f=true;
			
			
		} catch (Exception e) {
            
			e.printStackTrace();
		}
		
		
		return f;
		
		
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
boolean f =false;
		
		try {
			
			//jdbc code
			Connection connection = CP.createConnection();
			String qString = "select * from students;";
			
			Statement stmt = connection.createStatement();
			ResultSet set =   stmt.executeQuery(qString);
			
	        while (set.next()) {
				int id = set.getInt(1);
				String nameString = set.getString(2);
				String phoneString = set.getString(3);
				String cityString = set.getString("scity");
				
				System.out.println("ID : "+id);
				System.out.println("NAME : "+nameString);
				System.out.println("PHONE : "+phoneString);
				System.out.println("CITY : "+cityString);
				System.out.println("+++++++++++++++++++++++++++++++++++++++");
				
			}
			
		
			
			
		} catch (Exception e) {
            
			e.printStackTrace();
		}
		
		

		
	}
	
	
	
	

}
