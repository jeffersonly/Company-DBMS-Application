package milestone3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ProductWindow {
	
	public static void main(String[] args)
	{
		create();
	}
	
	public static void create()
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		frame.setTitle("Product Menu");
		
		//Set frame layout
		frame.setLayout(new FlowLayout());
		
		//JLabel header = new JLabel("Product Menu:");
		
		//Make buttons
		JButton productBuyButton = new JButton("Get Customer(s) of Product");
	
		//Make button bigger for frame
		productBuyButton.setPreferredSize(new Dimension(200, 50));
		
		//Add buttons
		//frame.add(header);
		frame.add(productBuyButton);
		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		//Adds actions
		productBuyButton.addActionListener(event -> new ProductBuyWindow().create());

	}
	
}