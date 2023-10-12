package sqlexample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductTable {

	public static void main(String[] args) {
		Connection con=null;
    	Statement st=null;
    	ResultSet rs=null;
    	
    	try 
    	{
		  Class.forName("com.mysql.cj.jdbc.Driver"); //loading the Driver
		  String url="jdbc:mysql://localhost:3306/Firstdb"; //Creating connection
		  String username="root";
		  String password="root";
		  con=DriverManager.getConnection(url, username, password);
		  
		  System.out.println(con);
		  st=con.createStatement();
		  
		  //String sql="create table Product(id int not null auto_increment,name varchar(200),category varchar(200),price float,brand varchar(200),rating float)";
		  //st.executeUpdate(sql);
		  String sql="insert into Product(name,category,price,brand,rating)values('Blue Shirt','Clothing',750,'Denim',3.8),('Blue Jeans','Clothing',800,'Puma',3.6),('Black Jeans','Clothing',750,'Denim',4.5),('Blue Shirt','Clothing',1000,'Puma',4.3),('Chocolate Cake','Food',25,'Britannia',3.7),('Strawberry Cake','Food',60,'Cadbury',4.1),('Chocolate Cake','Food',60,'Cadbury',2.5),('Strawberry Cake','Food',10,'Britannia',4.6),('Smart Watch','Gadgets',17000,'Apple',4.9),('Smart Cam','Gadgets',2600,'Realme',4.7),('Smart TV','Gadgets',40000,'Sony',4),('Smart Band','Gadgets',3000,'Realme',4.6),('Raw Cashew','Food',370,'Absa',3.9),('Cashew Nuts','Food',550,'Upcrop',4.3)";
		 
		  st.executeUpdate(sql);
		  sql="select * from Product where price<=1000";
		  rs=st.executeQuery(sql);
		  
		  while(rs.next())
		  {
			   System.out.println(rs.getInt(1)); 
			   System.out.println(rs.getString(2));
			   System.out.println(rs.getString(3));
			   System.out.println(rs.getFloat(4));
			   System.out.println(rs.getString(5));
			   System.out.println(rs.getFloat(6));
			   System.out.println("============");
		  }
		  sql="select gadgets from Product where rating>4.5";
		  rs=st.executeQuery(sql);
		  while(rs.next())
		  {
			  System.out.println(rs.getString(1));
		  }
		  //update price of SmartWatch to 15000 where no=9
		  sql="update Product set price=15000 where no=9";
		  st.executeUpdate(sql);
		  sql="select * from Product";
		  rs=st.executeQuery(sql);
		  
		  while(rs.next())
		  {
			   System.out.println(rs.getInt(1)); 
			   System.out.println(rs.getString(2));
			   System.out.println(rs.getString(3));
			   System.out.println(rs.getFloat(4));
			   System.out.println(rs.getString(5));
			   System.out.println(rs.getFloat(6));
			   System.out.println("============");
		  }
		  
		  //Delete products whose price is less than  100
		  
		  sql="delete from Product where price<100";
		  st.executeUpdate(sql);
    	}
    	catch(Exception e)
    	{
    		e.toString();
    	}
    	finally 
    	{
    		try 
    		{
    			con.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}	
    	}


	}

}
