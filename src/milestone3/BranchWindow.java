package milestone3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BranchWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		frame.setTitle("Branch Menu");
		//Set frame layout
		frame.setLayout(new GridLayout(3,2));
		
		//Make buttons
		JButton workBranchButton = new JButton("Employees of Branch");
		JButton branchInfoButton = new JButton("Branch Info");
		JButton cheapBranchButton = new JButton("Cheapest Product per Branch");
		JButton expProductButton = new JButton("Orders with most expensive Branch product");
	
		//Button size styling
		workBranchButton.setPreferredSize(new Dimension(300, 50));
		branchInfoButton.setPreferredSize(new Dimension(300, 50));
		cheapBranchButton.setPreferredSize(new Dimension(300, 50));
		expProductButton.setPreferredSize(new Dimension(300, 50));
		
		//Add buttons
		frame.add(workBranchButton);
		frame.add(branchInfoButton);
		frame.add(cheapBranchButton);
		frame.add(expProductButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		new WorkBranchWindow();
		//Adds actions
		workBranchButton.addActionListener(event -> WorkBranchWindow.create());
		
		branchInfoButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryD();
				new ResultsWindow();
				ResultsWindow.create(results);
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		new CheapBranchWindow();
		cheapBranchButton.addActionListener(event -> CheapBranchWindow.create());
		
		new ExpProductWindow();
		expProductButton.addActionListener(event -> ExpProductWindow.create());
	}
	
}