package milestone3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow {
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		
		//Set frame layout
		frame.setLayout(new FlowLayout());
		String s = "Evercreek Company Database Menu";
		frame.setTitle(s);
		
		//Make buttons
		JButton companyButton = new JButton("Company");
		JButton employeeButton = new JButton("Employee");
		JButton branchButton = new JButton("Branch");
		JButton productButton = new JButton("Product");
		JButton customerButton = new JButton("Customer");
		JButton stockButton = new JButton("Stock");
		
		//Sets size for buttons
		companyButton.setPreferredSize(new Dimension(100, 50));
		employeeButton.setPreferredSize(new Dimension(100, 50));
		branchButton.setPreferredSize(new Dimension(100, 50));
		productButton.setPreferredSize(new Dimension(100, 50));
		customerButton.setPreferredSize(new Dimension(100, 50));
		stockButton.setPreferredSize(new Dimension(100, 50));
		
		//Add buttons
		//frame.add(header);
		frame.add(companyButton);
		frame.add(employeeButton);
		frame.add(branchButton);
		frame.add(productButton);
		frame.add(customerButton);
		frame.add(stockButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Adds actions
		new CompanyWindow();
		companyButton.addActionListener(event -> CompanyWindow.create());
		new EmployeeWindow();
		employeeButton.addActionListener(event -> EmployeeWindow.create());
		new BranchWindow();
		branchButton.addActionListener(event -> BranchWindow.create());
		new ProductWindow();
		productButton.addActionListener(event -> ProductWindow.create());
		new CustomerWindow();
		customerButton.addActionListener(event -> CustomerWindow.create());
		new StockWindow();
		stockButton.addActionListener(event -> StockWindow.create());
		
	}
	

	
}