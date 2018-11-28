package milestone3;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		
		JLabel header = new JLabel("Evercreek Company Database Menu:");
		
		//Make buttons
		JButton companyButton = new JButton("Company");
		JButton employeeButton = new JButton("Employee");
		JButton branchButton = new JButton("Branch");
		JButton productButton = new JButton("Product");
		JButton customerButton = new JButton("Customer");
		JButton stockButton = new JButton("Stock");
	
		//Add buttons
		frame.add(header);
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
		companyButton.addActionListener(event -> new CompanyWindow().create());
		employeeButton.addActionListener(event -> new EmployeeWindow().create());
		branchButton.addActionListener(event -> new BranchWindow().create());
		productButton.addActionListener(event -> new ProductWindow().create());
		customerButton.addActionListener(event -> new CustomerWindow().create());
		stockButton.addActionListener(event -> new StockWindow().create());
		
		
		
	}
	

	
}