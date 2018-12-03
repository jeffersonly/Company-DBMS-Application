package milestone3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultsWindow {
	
	public static void main(String[] args)
	{
		
		ArrayList<String> test = new ArrayList<String>();
		test.add("A");
		test.add("B");
		
		create(test);
	}
	
	public static void create(ArrayList<String> input)
	{
		//Creates a new Frame
		JFrame frame = new JFrame();
		frame.setTitle("Results");
		
		//Set frame layout
		frame.setLayout(new GridLayout(input.size()+1,1));
		
		//JLabel header = new JLabel("Results:");
		//frame.add(header);
		
		if(input != null)
		{
			for(int i = 0; i < input.size(); i++)
			{
				JLabel results = new JLabel(input.get(i));
				
				//Add results
				frame.add(results);
			}
		}


		
		//Makes the frame open with the given buttons
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
}