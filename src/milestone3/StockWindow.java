package milestone3;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StockWindow {
	
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
		
		JLabel header = new JLabel("Stock Menu:");
		
		//Make buttons
		JButton investorButton = new JButton("Get Stock(s) of Specific Investor");
	
		//Add buttons
		frame.add(header);
		frame.add(investorButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		//Adds actions
		investorButton.addActionListener(event -> new InvestorWindow().create());

	}
	
}