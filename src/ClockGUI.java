import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ClockGUI {
	
	private static JLabel timeDisplay;
	private ClockBackEnd backEndObject;
	public ClockGUI() {
		backEndObject = new ClockBackEnd();
		timeDisplay = new JLabel("time");
	}
	 private void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Speaking clock");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	      //Create a panel and add components to it.
	        JPanel contentPane = new JPanel(new FlowLayout());
	        JButton button = new JButton("What's the time yao?");
	        button.setSize(50, 50);
	        
	        button.addActionListener(new ActionListener() { 
	        	public void actionPerformed(ActionEvent ae){ 
	        		timeDisplay.setText(""+backEndObject.getTime());
	        	}
	        });
	        contentPane.add(button);
	        contentPane.add(timeDisplay);
	        
	        frame.setContentPane(contentPane);
	        
	        //Display the window.
	        frame.pack();
	        frame.setSize(400,300);
	        frame.setVisible(true);
	 }
	 
	 
	 
	 public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	        new ClockGUI().createAndShowGUI();
	        new SpeechMaker();	        
	    }
}
