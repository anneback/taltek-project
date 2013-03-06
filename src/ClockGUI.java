import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ClockGUI {
	
	private JLabel timeDisplay = new JLabel();
	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("TopLevelDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	      //Create a panel and add components to it.
	        JPanel contentPane = new JPanel(new FlowLayout());
	        JButton button = new JButton("Vad är tiden?");
	        button.setSize(50, 50);
	        
	        //contentPane.add(timeDisplay);
	        contentPane.add(button);
	        
	        
	        frame.setContentPane(contentPane);
	        
	        //Display the window.
	        frame.pack();
	        frame.setSize(400,300);
	        frame.setVisible(true);
	 }
	 

	 public void mousePressed(MouseEvent e) {
		 timeDisplay.setText(""+new ClockBackEnd().getTime());
	 }
	 public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	        //new SpeechMaker();
	        
	        
	    }
}
