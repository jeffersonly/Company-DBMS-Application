package milestone3;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmployeeWindow {
	
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
		
		JLabel header = new JLabel("Employee Menu:");
		
		//Make buttons
		JButton managerButton = new JButton("Works for specific Manager");
	
		//Add buttons
		frame.add(header);
		frame.add(managerButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		//Adds actions
		managerButton.addActionListener(event -> new ManagerWindow().create());
	}
	
}