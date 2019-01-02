package milestone3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EmployeeWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		frame.setTitle("Employee Menu");
		
		//Set frame layout
		frame.setLayout(new FlowLayout());
		
		//Make buttons
		JButton managerButton = new JButton("Works for specific Manager");
	
		//Make button size better
		managerButton.setPreferredSize(new Dimension(250, 50));
		
		//Add buttons
		frame.add(managerButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		new ManagerWindow();
		//Adds actions
		managerButton.addActionListener(event -> ManagerWindow.create());
		
	}
	
}