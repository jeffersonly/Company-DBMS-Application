package milestone3;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExpProductWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		frame.setTitle("Branch Orders");
		
		//Set frame layout
		frame.setLayout(new FlowLayout());
		
		JLabel header = new JLabel("Submit Branch Name for Orders:");
		
		
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
				if(!input.trim().equals(""))
				{
					ArrayList<String> results = con.queryN(input);
					new ResultsWindow();
					ResultsWindow.create(results);
				}
				else
				{
					JFrame frame1 = new JFrame();
					frame1.add(new JLabel("Please enter a value"));
					frame1.pack();
					frame1.setVisible(true);
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});				
	}
	
}