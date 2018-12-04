package milestone3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CustomerWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		frame.setTitle("Customer Menu");
		//Set frame layout
		frame.setLayout(new FlowLayout());
		
		//JLabel header = new JLabel("Customer Menu:");
		
		//Make buttons
		JButton moreProductButton = new JButton("Get Customer(s) that bought more than one Product");
	
		//Make button size larger
		moreProductButton.setPreferredSize(new Dimension(400, 50));
		
		//Add buttons
		//frame.add(header);
		frame.add(moreProductButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		//Adds actions
		moreProductButton.addActionListener(event -> {
			try {
				
				TheConnection con = new TheConnection();
				ArrayList<String> results = con.queryG();
				new ResultsWindow();
				ResultsWindow.create(results);
				
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
}