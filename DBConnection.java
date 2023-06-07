package Dao;
import java.sql.*;
import java.util.ArrayList;

import Entity.Student;
public class DBConnection {

	public static ArrayList<Student> select() throws  SQLException, ClassNotFoundException{
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springjdbc","root","1234");
		
		
		Statement stmt=c.createStatement();
		
		ResultSet r =stmt.executeQuery("select * from student");
		
		
		ArrayList<Student> a=new ArrayList<Student>();
		
		while(r.next()) {
			
			Student std = new Student (r.getInt(1),r.getString(2),r.getString(3));
			
			a.add(std);
			
		}
		
		
		return a;
		
	}
	
}
