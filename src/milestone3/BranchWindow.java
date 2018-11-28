package milestone3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BranchWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		
		//Set frame layout
		frame.setLayout(new GridLayout(3,2));
		
		JLabel header = new JLabel("Branch Menu:");
		
		//Make buttons
		JButton workBranchButton = new JButton("Employees of Branch");
		JButton branchInfoButton = new JButton("Branch Info");
		JButton cheapBranchButton = new JButton("Cheapest Product per Branch");
		JButton expProductButton = new JButton("Orders with most expensive Branch product");
	
		//Add buttons
		frame.add(header);
		frame.add(workBranchButton);
		frame.add(branchInfoButton);
		frame.add(cheapBranchButton);
		frame.add(expProductButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		//Adds actions
		workBranchButton.addActionListener(event -> new WorkBranchWindow().create());
		
		branchInfoButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryD();
				new ResultsWindow().create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		cheapBranchButton.addActionListener(event -> new CheapBranchWindow().create());
		
		expProductButton.addActionListener(event -> new ExpProductWindow().create());
	}
	
}