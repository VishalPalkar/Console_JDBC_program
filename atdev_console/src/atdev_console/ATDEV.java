package atdev_console;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;
public class ATDEV 
{
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
			System.out.println("Please select an operation and enter the corresponding number...!");	
			System.out.println("1 ---> Insert student data");
			System.out.println("2 ---> Update student data");
			System.out.println("3 ---> Delate student data");
			System.out.println("4 ---> List of all student data");
			System.out.println("5 ---> Show one student data");
			
			int j=sc.nextInt();
					if (j==1) {
                       insertrecord();
                      } else if (j==2) 
                      {
                        updaterecord();
                      } 
                      else if (j==3) 
                      {
                        deleterecord();
                      }  
                      else if (j==4) {
                    	  listallrecord();
                      } 
                      else if (j==5) {
                    	  singlerecord();
                      } 
                      else 
                      {
                    	  System.out.println("please enter a valid number....!");
                      }
}

	
	private static void singlerecord() {
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/atdev","root","password");
		    System.out.println("!.....database connected.....!");
		    Statement selectStmt = con.createStatement();
		    System.out.println("Enter student Id");
			int no=sc.nextInt();
			String sqlq =("SELECT * FROM STUDENT WHERE STUDENT_NO=?");
			PreparedStatement st= con.prepareStatement(sqlq);
			st.setInt(1,no);
			ResultSet rs = st.executeQuery(); 
			System.out.println("NO           DOB                DOJ           NAME");
		    while(rs.next())
	    	{
	    	    System.out.print(rs.getInt(1));
	    	    System.out.print("        ");
	    	    System.out.print(rs.getString(2));
	    	    System.out.print("        ");
	    	    System.out.print(rs.getString(3)); 
	    	    System.out.print("        ");
	    	    System.out.print(rs.getString(4)); 
	    	    System.out.println();
	    	}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	private static void listallrecord() {
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/atdev","root","password");
		    System.out.println("!.....database connected.....!");
		    Statement selectStmt = con.createStatement();
		    ResultSet rs = selectStmt.executeQuery("SELECT * FROM STUDENT");
		    System.out.println("NO           DOB                DOJ           NAME");
		    while(rs.next())
	    	{
	    	    System.out.print(rs.getInt(1));
	    	    System.out.print("        ");
	    	    System.out.print(rs.getString(2));
	    	    System.out.print("        ");
	    	    System.out.print(rs.getString(3)); 
	    	    System.out.print("        ");
	    	    System.out.print(rs.getString(4)); 
	    	    System.out.println();
	    	}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	private static void deleterecord() {
		
			try
			{
				Scanner sc=new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/atdev","root","password");
			    System.out.println("!.....database connected.....!");
			   
			    
			    System.out.println("Caution!..... Delete operation selected."); 
			    System.out.println("Enter student Id to delete");
				int no=sc.nextInt();
				String sqlq = "DELETE FROM STUDENT WHERE STUDENT_NO=?";
	            PreparedStatement st = con.prepareStatement(sqlq);
	            st.setInt(1,no);
	            st.executeUpdate();
	            System.out.println("Deleted Successfully....!");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		
		
	}

	private static void updaterecord() {
	
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/atdev","root","password");
		    System.out.println("!.....database connected.....!");
		    System.out.println("Update operation selected..."); 
		    System.out.println("Enter student Id to be updated");
			int no=sc.nextInt();
		    System.out.println("Enter Name");
			String name=sc.next(); 
			System.out.println("Enter DOB");
			String dob=sc.next();
			System.out.println("Enter DOJ");
			String doj=sc.next();
			String sqlq = "UPDATE STUDENT SET STUDENT_DOB=?,STUDENT_DOJ=?,STUDENT_NAME=? WHERE STUDENT_NO=?";
            PreparedStatement st = con.prepareStatement(sqlq);
            st.setString(1,dob);
            st.setString(2,doj);
            st.setString(3,name);
            st.setInt(4,no);
            st.executeUpdate();
            System.out.println("Updated Successfully...!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	private static void insertrecord() {
		
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/atdev","root","password");
	        System.out.println("!.....database connected.....!");
		    System.out.println("Insert operation selected..."); 
		    System.out.println("Enter Student Id");
			int no=sc.nextInt();
		    System.out.println("Enter Name");
			String name=sc.next(); 
			System.out.println("Enter DOB");
			String dob=sc.next();
			System.out.println("Enter DOJ");
			String doj=sc.next();
			String sqlq = "INSERT INTO STUDENT(STUDENT_NO,STUDENT_DOB,STUDENT_DOJ,STUDENT_NAME) values (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sqlq);
            st.setInt(1,no);
            st.setString(2,dob);
            st.setString(3,doj);
            st.setString(4,name);
            st.executeUpdate();
            System.out.println("Inserted Successfully....");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	
}
