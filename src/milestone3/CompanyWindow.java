package milestone3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		
		JLabel header = new JLabel("Company Menu:");
		
		//Make buttons
		JButton allBranchesButton = new JButton("Get all Branch Names");
		JButton yearButton = new JButton("Years Worked");
		JButton salaryBranchButton = new JButton("Salary per Branch");
		JButton priceCostButton = new JButton("Price and Cost of most Successful Product");
		JButton investorButton = new JButton("Employees/Managers that are also Investors");
		JButton priceCost2Button = new JButton("Most Costly Unpopular Product");
		JButton distinctButton = new JButton("Distinct Employees, Managers, and Investors");
	
		//Add buttons
		frame.add(header);
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
			
				new ResultsWindow().create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		yearButton.addActionListener(event -> new YearWindow().create());
		salaryBranchButton.addActionListener(event -> new SalaryBranchWindow().create());
		
		priceCostButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryJ();
				new ResultsWindow().create(results);
				
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
				new ResultsWindow().create(results);
				
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
				new ResultsWindow().create(results);
				
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
				new ResultsWindow().create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
	}
	
}