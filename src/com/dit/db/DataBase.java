package com.dit.db;
import java.sql.*;
import java.util.*;

import com.dit.models.*;
public class DataBase {
	Statement stmt;
	public DataBase(){
		 try {
  		   Class.forName("com.mysql.cj.jdbc.Driver");
  		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","G13pics007@");
  		   this.stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  		   this.stmt.execute("CREATE DATABASE IF NOT EXISTS user_data");
  		   this.stmt.execute("USE  user_data");
  		   this.stmt.execute("CREATE TABLE IF NOT EXISTS users(\r\n"
  		   		+ "						 sap_id VARCHAR(20) PRIMARY KEY ,\r\n"
  		   		+ "						 password VARCHAR(20) ,\r\n"
  		   		+ "						 roll_no VARCHAR(11), \r\n"
  		   		+ "	  		   		     name   VARCHAR(20), \r\n"
  		   		+ "			  		     current_cgpa  DOUBLE,\r\n"
  		   		+ "						 sem INT, \r\n"
  		   		+ "						 total_sem INT , \r\n"
  		   		+ "			  		     branch VARCHAR(10) )");
  		   this.stmt.execute("CREATE TABLE IF NOT EXISTS companies(\r\n"
   		   		+ "						 id VARCHAR(20) PRIMARY KEY ,\r\n"
   		   		+ "						 name VARCHAR(20) ,\r\n"
   		   		+ "						 job_type VARCHAR(11), \r\n"
   		   		+ "	  		   		     location VARCHAR(20), \r\n"
   		   		+ "			  		     ctc  INT,\r\n"
   		   		+ "						 eligibility DOUBLE, \r\n"
   		   		+ "			  		     branches VARCHAR(30) )");	   
  		   
  	    }
  	    catch(Exception e) {
  		   System.out.println("in cons: "+e.toString());
  	   }
	}
	public List<Company> getCompanies(User user){
		List<Company> companyList=new ArrayList<Company>();
		 try {
	    	   String query="SELECT * from companies "
	    			        +"WHERE   branches LIKE "
	    			        +"\"%"+ user.branch+"%\" "
	    			        +"AND eligibility<=" 
	    			        + user.current_cgpa;
	    	   System.out.println(query);
			   ResultSet rs=stmt.executeQuery(query);
			   ;
			   while(rs.next()) {
				   companyList.add(new Company(rs.getString("name"),
						                   rs.getString("job_type"),
						                   rs.getString("location"),
						                   rs.getInt("ctc"),
						                   rs.getDouble("eligibility"),
						                   rs.getString("branches").split(",")));
			   }
		 }
		 catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		 return companyList;
		
	}
    public User getUser(String sapId,String password) {
    	 try {
    	   String query="SELECT * from users "
    			        +"WHERE sap_id="
    			        +"\""+sapId+"\""
    			        +" AND password="
    			        +"\""+password+"\"";
    	   //System.out.println(query);
		   ResultSet rs=stmt.executeQuery(query);
		  
		   return rs.next()
					   ?new User(rs.getString("sap_id"),
							     rs.getString("roll_no"),
							     rs.getString("name"),
							     Double.parseDouble(rs.getString("current_cgpa")),
							     Integer.parseInt(rs.getString("sem")),
							     Integer.parseInt(rs.getString("total_sem")),
							     rs.getString("branch")
							     )
					   : null;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    public User addUser(String sapId,String rollno,String name,double current_cgpa,int sem,int totalSem,String branch,String password){
        String query="INSERT INTO users(sap_id,password,roll_no,name,current_cgpa,sem,total_sem,branch)"
        		      +String.format(" VALUES(\"%s\",\"%s\",\"%s\",\"%s\",%s,%s,%s,\"%s\")",
        		    		  sapId, password,rollno,name,current_cgpa,sem, totalSem, branch) ;  
        //System.out.println(query);
    	try {
			this.stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return getUser(sapId,password);
    	
    }
       public static void main(String args[]) {
    	  DataBase db=new DataBase();
    	  System.out.println(db.getUser("1000015166", "G13pics007@"));
    	  db.addUser("1000015166","200102529","Ehson",7.82,7,8,"BT-CSE","G13pics007@");
    	  System.out.println(db.getUser("1000015166", "G13pics007@"));
    	  
       }

}

