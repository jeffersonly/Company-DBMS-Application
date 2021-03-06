package milestone3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CompanyWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		
		//Set frame layout
		frame.setLayout(new GridLayout(4,2));
		
		//JLabel header = new JLabel("Company Menu:");
		frame.setTitle("Company Menu");
		
		//Make buttons
		JButton allBranchesButton = new JButton("Get all Branch Names");
		JButton yearButton = new JButton("Years Worked");
		JButton salaryBranchButton = new JButton("Salary per Branch");
		JButton priceCostButton = new JButton("Price and Cost of most Successful Product");
		JButton investorButton = new JButton("Employees/Managers that are also Investors");
		JButton priceCost2Button = new JButton("Most Costly Unpopular Product");
		JButton distinctButton = new JButton("Distinct Employees, Managers, and Investors");
	
		//Styling for buttons sizing
		allBranchesButton.setPreferredSize(new Dimension(300, 50));
		yearButton.setPreferredSize(new Dimension(300, 50));
		salaryBranchButton.setPreferredSize(new Dimension(300, 50));
		priceCostButton.setPreferredSize(new Dimension(300, 50));
		investorButton.setPreferredSize(new Dimension(300, 50));
		priceCost2Button.setPreferredSize(new Dimension(300, 50));
		distinctButton.setPreferredSize(new Dimension(300, 50));
		
		//Add buttons
		//frame.add(header);
		frame.add(allBranchesButton);
		frame.add(yearButton);
		frame.add(salaryBranchButton);
		frame.add(priceCostButton);
		frame.add(investorButton);
		frame.add(priceCost2Button);
		frame.add(distinctButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		//Adds actions
		allBranchesButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryB();
			
				new ResultsWindow();
				ResultsWindow.create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		new YearWindow();
		yearButton.addActionListener(event -> YearWindow.create());
		new SalaryBranchWindow();
		salaryBranchButton.addActionListener(event -> SalaryBranchWindow.create());
		
		priceCostButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryJ();
				new ResultsWindow();
				ResultsWindow.create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		investorButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryK();
				new ResultsWindow();
				ResultsWindow.create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		priceCost2Button.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryL();
				new ResultsWindow();
				ResultsWindow.create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		distinctButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryO();
				new ResultsWindow();
				ResultsWindow.create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
	}
	
}