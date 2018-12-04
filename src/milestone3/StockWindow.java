package milestone3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StockWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		frame.setTitle("Stock Menu");
		
		//Set frame layout
		frame.setLayout(new FlowLayout());
		
		//Make buttons
		JButton investorButton = new JButton("Get Stock(s) of Specific Investor");
	
		//Button sizing
		investorButton.setPreferredSize(new Dimension(300, 50));
		
		//Add buttons
		frame.add(investorButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		//Adds actions
		new InvestorWindow();
		investorButton.addActionListener(event -> InvestorWindow.create());

	}
	
}