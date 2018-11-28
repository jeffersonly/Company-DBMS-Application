package milestone3;

import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class TheConnection
{
	public static String USERNAME = new String("root");
    public static String PASSWORD = new String("password");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/");
	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");
	
	public ArrayList<String> branches;
	
	public TheConnection()
	{
	 branches = new ArrayList<String>();
	}

	public static void main(String[] args) throws ClassNotFoundException
	{
		TheConnection test = new TheConnection();
		
		ArrayList<String> results = test.queryK();
		
		System.out.println(results);

	}	
	
	
	public ArrayList<String> queryB() throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT branchName " + 
					  "FROM Branches;");

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery("SELECT branchName " + 
						  "FROM Branches;");
				
			while ( rs.next() ) 
			{ 	String name = rs.getString("branchName");
				branches.add(name); 
				System.out.println(name);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryG() throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT DISTINCT c.customerID, c.firstName, c.lastName " + 
					  "FROM Customers c, Has h, Has h2 " + 
					  "WHERE h.customerID = h2.customerID " + 
					  "AND h.orderID != h2.orderID " + 
					  "AND h.customerID = c.customerID;");
		

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT DISTINCT c.customerID, c.firstName, c.lastName " + 
					  "FROM Customers c, Has h, Has h2 " + 
					  "WHERE h.customerID = h2.customerID " + 
					  "AND h.orderID != h2.orderID " + 
					  "AND h.customerID = c.customerID;");
				
			while ( rs.next() ) 
			{ 	String customerID = rs.getString("c.customerID");
				String firstName = rs.getString("c.firstName");
				String lastName = rs.getString("c.lastName");
			
			
				branches.add("CustomerID: " + customerID + ", First Name: " + firstName + ", Last Name: "+ lastName); 
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}

	public ArrayList<String> queryJ() throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT p.priceSold, p.costToMake " + 
					  "FROM Products p, MadeOf m " + 
					  "WHERE m.productID = p.productID " + 
					  "AND m.quantity >= ALL(SELECT quantity FROM MadeOf);");
		

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT p.priceSold, p.costToMake " + 
					  "FROM Products p, MadeOf m " + 
					  "WHERE m.productID = p.productID " + 
					  "AND m.quantity >= ALL(SELECT quantity FROM MadeOf);");
				
			while ( rs.next() ) 
			{ 	String price = rs.getString("p.priceSold");
				String cost = rs.getString("p.costToMake");
				branches.add("Product Selling Price: " + price + ", Cost to Make Product: " + cost); 
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryO() throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "(SELECT firstName, lastName, email, IDNumber " + 
					  "FROM Employees) " + 
					  "UNION " + 
					  "(SELECT firstName, lastName, email, IDNumber " + 
					  "FROM Managers) " + 
					  "UNION " + 
					  "(SELECT firstName, lastName, email, IDNumber " + 
					  "FROM Investors " + 
					  "WHERE IDNumber != ANY (SELECT IDNumber FROM Employees) " + 
					  "AND IDNumber != ANY (SELECT IDNumber FROM Managers));");
		

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "(SELECT firstName, lastName, email, IDNumber " + 
					  "FROM Employees) " + 
					  "UNION " + 
					  "(SELECT firstName, lastName, email, IDNumber " + 
					  "FROM Managers) " + 
					  "UNION " + 
					  "(SELECT firstName, lastName, email, IDNumber " + 
					  "FROM Investors " + 
					  "WHERE IDNumber != ANY (SELECT IDNumber FROM Employees) " + 
					  "AND IDNumber != ANY (SELECT IDNumber FROM Managers));");
				
			while ( rs.next() ) 
			{ 	String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String IDNumber = rs.getString("IDNumber");
				branches.add("First Name: " + firstName + ", Last Name: " + lastName + ", E-mail: " + email + ", Employee ID: " + IDNumber); 
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryL() throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT p.name, p.productID " + 
					  "FROM Products p, MadeOf m " + 
					  "WHERE m.productID = p.productID " + 
					  "AND m.quantity <= ALL(SELECT quantity FROM MadeOf) " + 
					  "AND p.costToMake >= ALL " + 
					  "(SELECT p2.costToMake " + 
					  "FROM Products p2, MadeOf m2 " + 
					  "WHERE m2.productID = p2.productID " + 
					  "AND m2.quantity <= ALL(SELECT quantity FROM MadeOf));"  
					  );
		

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT p.name, p.productID " + 
					  "FROM Products p, MadeOf m " + 
					  "WHERE m.productID = p.productID " + 
					  "AND m.quantity <= ALL(SELECT quantity FROM MadeOf) " + 
					  "AND p.costToMake >= ALL " + 
					  "(SELECT p2.costToMake " + 
					  "FROM Products p2, MadeOf m2 " + 
					  "WHERE m2.productID = p2.productID " + 
					  "AND m2.quantity <= ALL(SELECT quantity FROM MadeOf));"  
					  );
				
			while ( rs.next() ) 
			{ 	String productName = rs.getString("p.name");
				String productID = rs.getString("p.productID");
				branches.add("Product Name: " + productName + ", Product ID: " + productID); 
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryK() throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "(SELECT e.IDNumber, e.firstName, e.lastName " + 
					  "FROM Employees e, Investors i " + 
					  "WHERE e.IDNumber = i.IDNumber) " + 
					  "UNION " + 
					  "(SELECT m.IDNumber, m.firstName, m.lastName " + 
					  "FROM Managers m, Investors i " + 
					  "WHERE m.IDNumber = i.IDNumber);");
		

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "(SELECT e.IDNumber, e.firstName, e.lastName " + 
					  "FROM Employees e, Investors i " + 
					  "WHERE e.IDNumber = i.IDNumber) " + 
					  "UNION " + 
					  "(SELECT m.IDNumber, m.firstName, m.lastName " + 
					  "FROM Managers m, Investors i " + 
					  "WHERE m.IDNumber = i.IDNumber);");
				
			while ( rs.next() ) 
			{ 	String idNumber = rs.getString("IDNumber");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				branches.add("ID Number: " + idNumber + ", First Name: " + firstName + ", Last Name: " + lastName); 
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryA(int input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT e.IDNumber, e.firstName, e.lastName " + 
					  "FROM Employees e, Manages m " + 
					  "WHERE m.managerID =" + input + " " + 
					  "AND m.employeeID = e.IDNumber;" 
					  );
		

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT e.IDNumber, e.firstName, e.lastName " + 
					  "FROM Employees e, Manages m " + 
					  "WHERE m.managerID =" + input + " " + 
					  "AND m.employeeID = e.IDNumber;" 
					  );
				
			while ( rs.next() ) 
			{ 	String idNumber = rs.getString("IDNumber");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				branches.add("ID Number: " + idNumber + ", First Name: " + firstName + ", Last Name: " + lastName); 
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryH(int input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT " + 
					  "(SELECT COUNT(*) " + 
					  "FROM employees " + 
					  "WHERE startDate < DATE_SUB(SYSDATE(), INTERVAL " + input +" YEAR)) " + 
					  "+ " + 
					  "(SELECT COUNT(*) " + 
					  "FROM managers " + 
					  "WHERE startDate < DATE_SUB(SYSDATE(), INTERVAL " + input + " YEAR)) " + 
					  "AS LongTermEmployees;");

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT " + 
					  "(SELECT COUNT(*) " + 
					  "FROM employees " + 
					  "WHERE startDate < DATE_SUB(SYSDATE(), INTERVAL " + input +" YEAR)) " + 
					  "+ " + 
					  "(SELECT COUNT(*) " + 
					  "FROM managers " + 
					  "WHERE startDate < DATE_SUB(SYSDATE(), INTERVAL " + input + " YEAR)) " + 
					  "AS LongTermEmployees;");
				
			while ( rs.next() ) 
			{ 	String count = rs.getString("LongTermEmployees");
				branches.add(count); 
				System.out.println(count);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryC(String input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "(SELECT e.IDNumber, e.firstName, e.lastName " + 
					  "FROM Employees e, Contains c " + 
					  "WHERE c.branchName LIKE '%" + input + "%' " + 
					  "AND c.employeeID = e.IDNumber) " + 
					  "UNION " + 
					  "(SELECT m.IDNumber, m.firstName, m.lastName " + 
					  "FROM Managers m, RunBy r " + 
					  "WHERE r.branchName LIKE '%"+ input +"%' " + 
					  "AND r.managerID = m.IDNumber);" );

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "(SELECT e.IDNumber, e.firstName, e.lastName " + 
					  "FROM Employees e, Contains c " + 
					  "WHERE c.branchName LIKE '%" + input + "%' " + 
					  "AND c.employeeID = e.IDNumber) " + 
					  "UNION " + 
					  "(SELECT m.IDNumber, m.firstName, m.lastName " + 
					  "FROM Managers m, RunBy r " + 
					  "WHERE r.branchName LIKE '%"+ input +"%' " + 
					  "AND r.managerID = m.IDNumber);" );
				
			while ( rs.next() ) 
			{ 	String IDNumber = rs.getString("IDNumber");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				branches.add("ID Number: " + IDNumber + ", First Name: " + firstName + ", Last Name: " + lastName);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryM(String input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT p.name, p.productID " + 
					  "FROM Products p, Makes m " + 
					  "WHERE p.productID = m.productID " + 
					  "AND m.branchName LIKE '%Electronics%' " + 
					  "AND p.costToMake>= ALL " + 
					  "(SELECT p2.costToMake " + 
					  "FROM Products p2, Makes m2 " + 
					  "WHERE p2.productID = m2.productID " + 
					  "AND m2.branchName LIKE '%Electronics%');");

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT p.name, p.productID " + 
					  "FROM Products p, Makes m " + 
					  "WHERE p.productID = m.productID " + 
					  "AND m.branchName LIKE '%Electronics%' " + 
					  "AND p.costToMake>= ALL " + 
					  "(SELECT p2.costToMake " + 
					  "FROM Products p2, Makes m2 " + 
					  "WHERE p2.productID = m2.productID " + 
					  "AND m2.branchName LIKE '%Electronics%');");
				
			while ( rs.next() ) 
			{ 	String name = rs.getString("p.name");
				String id = rs.getString("p.productID");
				System.out.println("TEST");
				branches.add("Product Name: " + name + ", Product ID: " + id);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryD() throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT branchName, dateCreated, cost, profit " + 
					  "FROM Branches;");

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT branchName, dateCreated, cost, profit " + 
					  "FROM Branches;");
				
			while ( rs.next() ) 
			{ 	String name = rs.getString("branchName");
				String date = rs.getString("dateCreated");
				String cost = rs.getString("cost");
				String profit = rs.getString("profit");
				
				branches.add("Branch Name: " + name + ", Date Created: " + date+ ", Cost of Branch: " + cost+ ", Branch Profit: " + profit);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryE(int input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT c.customerID, c.firstName, c.lastName " + 
					  "FROM Customers c, Buys b " + 
					  "WHERE b.productID = " + input + " " + 
					  "AND b.customerID = c.customerID;");

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT c.customerID, c.firstName, c.lastName " + 
					  "FROM Customers c, Buys b " + 
					  "WHERE b.productID = " + input + " " + 
					  "AND b.customerID = c.customerID;");
				
			while ( rs.next() ) 
			{ 	String id = rs.getString("c.customerID");
				String firstName = rs.getString("c.firstName");
				String lastName = rs.getString("c.lastName");
				
				branches.add("Customer ID: " + id + ", First Name: " + firstName+ ", Last Name: " + lastName);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryI(String input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "(SELECT e.salary " + 
					  "FROM Employees e, Contains c " + 
					  "WHERE e.IDNumber = c.employeeID " + 
					  "AND c.branchName LIKE '%" + input + "%') " + 
					  "UNION " + 
					  "(SELECT m.salary " + 
					  "FROM Managers m, RunBy r " + 
					  "WHERE m.IDNumber = r.managerID " + 
					  "AND r.branchName LIKE '%" + input + "%');");

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "(SELECT e.salary " + 
					  "FROM Employees e, Contains c " + 
					  "WHERE e.IDNumber = c.employeeID " + 
					  "AND c.branchName LIKE '%" + input + "%') " + 
					  "UNION " + 
					  "(SELECT m.salary " + 
					  "FROM Managers m, RunBy r " + 
					  "WHERE m.IDNumber = r.managerID " + 
					  "AND r.branchName LIKE '%" + input + "%');");
				
			while ( rs.next() ) 
			{ 	String salary = rs.getString("salary");
				
				branches.add("Salary: " + salary);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryF(int input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT s.stockID, stock.price, stock.numShared " + 
					  "FROM Stocks s, InvestsIn i " + 
					  "WHERE i.InvestorID = 93193 " + 
					  "AND i.stockID = s.stockID; " );

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT s.stockID, s.price, s.numShared " + 
					  "FROM Stocks s, InvestsIn i " + 
					  "WHERE i.InvestorID =" +input + " " + 
					  "AND i.stockID = s.stockID; " );
				
			while ( rs.next() ) 
			{ 	String id = rs.getString("s.stockID");
				String price = rs.getString("s.price");
				String num = rs.getString("s.numShared");
				
				branches.add("Stock ID: " + id + ", Stock Price: " + price + ", Number Shared: " + num);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
	public ArrayList<String> queryN(String input) throws ClassNotFoundException
	{
		// Load the Driver
		Class.forName(JDBC_DRIVER);
		
		Connection con = null;
		
		ArrayList<String> branches = new ArrayList<String>();

		try
		{
			// Get a connection from the connection factory
			con = DriverManager.getConnection(
			DB_URL,
			  //"jdbc:oracle:thin:@dbaprod1:1521:SHR1_PRD",
			USERNAME, PASSWORD);
			
	
			// Show some database/driver metadata
			SQLUtil.printDriverInfo(con);
			
			PreparedStatement stmt = con.prepareStatement(
					"USE milestone3");
			
			Statement pstmt = con.prepareStatement(
					  "SELECT Has.orderID, firstName, lastName, email " + 
					  "FROM Customers, Has " + 
					  "WHERE Customers.customerID IN ( " + 
					  "	SELECT customerID " + 
					  "    FROM Buys " + 
					  "    WHERE Buys.productID IN ( " + 
					  "		SELECT productID " + 
					  "		FROM Products " + 
					  "		WHERE priceSold = ( " + 
					  "			SELECT MAX(priceSold) " + 
					  "			FROM Products \r\n" + 
					  "			WHERE productID IN ( " + 
					  "				SELECT productID  " + 
					  "				FROM Makes\r\n" + 
					  "				WHERE branchName LIKE '%Software%')))) " + 
					  "	AND Has.customerID = Customers.customerID;");

			// Do all updates in a single transaction
			con.setAutoCommit(false);
			
			stmt.executeQuery();
	

			// Submit the statement

			ResultSet rs = stmt.executeQuery(
					  "SELECT Has.orderID, firstName, lastName, email " + 
					  "FROM Customers, Has " + 
					  "WHERE Customers.customerID IN ( " + 
					  "	SELECT customerID " + 
					  "    FROM Buys " + 
					  "    WHERE Buys.productID IN ( " + 
					  "		SELECT productID " + 
					  "		FROM Products " + 
					  "		WHERE priceSold = ( " + 
					  "			SELECT MAX(priceSold) " + 
					  "			FROM Products " + 
					  "			WHERE productID IN ( " + 
					  "				SELECT productID  " + 
					  "				FROM Makes" + 
					  "				WHERE branchName LIKE '%" + input + "%')))) " + 
					  "	AND Has.customerID = Customers.customerID;");
				
			while ( rs.next() ) 
			{ 	String id = rs.getString("Has.orderID");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				
				branches.add("Order ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName+ ", E-mail: " + email);
			}

			// Commit the work
			con.commit();
			con.setAutoCommit(true);

			// Close the statement
			pstmt.close();
			
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 	
			try
			{
				System.err.println("Yikes, rolling back!");
				con.rollback();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          		 }
          	}
		
          	finally
          	{
          		
			try
			{
				// Close the connection
   	      	 		if (con != null)
          	 			con.close();
			}
			catch (SQLException e2)
			{
          		 	SQLUtil.printSQLExceptions(e2);		
          	}
			
        }
		return branches;
	}
	
}
	