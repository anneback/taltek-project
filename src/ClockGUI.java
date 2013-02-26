import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ClockGUI {
	
	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("TopLevelDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	      //Create a panel and add components to it.
	        JPanel contentPane = new JPanel(new FlowLayout());
	        JButton button = new JButton("Vad är tiden?");
	        button.setSize(50, 50);
	        
	        contentPane.add(button);

	        frame.setContentPane(contentPane);
	        
	        //Display the window.
	        frame.pack();
	        frame.setSize(400,300);
	        frame.setVisible(true);
	 }
	 public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
}
