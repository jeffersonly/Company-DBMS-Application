1.) The scripts are run through MySQL Workbench 8.0 CE. Eclipse Java Photon June 2018 is used as well.

2.) For milestone3Load.sql, the default file location set for loading data is '/Users/Rick/Desktop/Milestone3/milestone3txtfiles/'. The file location must be changed to the appropriate location before running the script. 

3.) For JDBC, the default database used is "milestone3". To change this, go to TheConnection class in Java and go to every query method to change the line: 			
PreparedStatement stmt = con.prepareStatement("USE milestone3");

4.) For JDBC, to change the database data, go to TheConnection class in Java and edit the 4 variables

	public static String USERNAME = new String("root");
    public static String PASSWORD = new String("richard1998");
	public static String DB_URL = new String("jdbc:mysql://localhost:3306/");
	public static String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");

5.) All SQL Scripts will either create or use a database called "milestone3". To change this, go to all the sql script files and change it.

6.) *** RUN THE FOLLOWING SQL SCRIPTS BEFORE RUNNING THE JAVA PROJECT ***
	Run the scripts in the following order:
	1.milestone3CreateDatabase
	2.milestone3CreateTables
	3.milestone3Indexes
	4.milestone3Views
	5.milestone3Load (which may require permission)

7.) Bring the milestone3Java.zip into Eclipse. In Eclipse, run the application through the MainWindow class.

8.) If you want to refer to specific data, all inputted data are located in the excel file Project Data Table 

9.) Refer to milestone3Queries if you want to see all required queries.

10.) To see proposed statements that were not implemented the project, refer to the following files:
	1.milestone3Transactions
	2.milestone3Triggers