package milestone3;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WorkBranchWindow {
	
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
		
		JLabel header = new JLabel("Submit Branch Name for Workers:");
		
		
		//TextField
		JTextField branch = new JTextField("",10);
		
		//Make buttons
		JButton submitButton = new JButton("Submit");
	
		//Add buttons
		frame.add(header);
		frame.add(branch);
		frame.add(submitButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		//Adds actions
		submitButton.addActionListener(event -> {
			try {
				String input = branch.getText();
				
				TheConnection con = new TheConnection();
				System.out.println("Success");
				ArrayList<String> results = con.queryC(input);
				new ResultsWindow().create(results);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});				
	}
	
}