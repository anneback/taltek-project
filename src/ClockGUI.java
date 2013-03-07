import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ClockGUI {
	
	private static JLabel timeDisplay;
	private ClockBackEnd backEndObject;
	private String voice;
	
	public ClockGUI() {
		backEndObject = new ClockBackEnd();
		timeDisplay = new JLabel("time");
		this.voice = "Jesper";
	}
	 private void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Speaking clock");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	      //Create a panel and add components to it.
	        //JPanel contentPane = new JPanel(new FlowLayout());
	        JPanel contentPane = new JPanel(new GridBagLayout());
	        Color color = new Color(238,233,191);
	        contentPane.setBackground(color);
	        GridBagConstraints c = new GridBagConstraints();
	        
	        ImageIcon image = new ImageIcon("clocksmall.jpg");
	        JLabel label = new JLabel("", image, JLabel.CENTER);
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.insets = new Insets(10,10,10,10);
	        c.gridx = 1;
	        c.gridy = 0;
	        contentPane.add(label,c);
	        
	        
	        
	        JButton getTimeButton = new JButton("What's the time yao?");
	        getTimeButton.setSize(50, 50);
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 1;
	        c.gridy = 1;
	        contentPane.add(getTimeButton,c);
	        
	        getTimeButton.addActionListener(new ActionListener() { 
	        	public void actionPerformed(ActionEvent ae){ 
	        		try {
						timeDisplay.setText(""+backEndObject.getTime(voice));
					} catch (UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        });
	        
	        final JButton chooseAsaButton = new JButton("Åsa");
	        chooseAsaButton.setSize(50, 50);
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 0;
	        c.gridy = 2;
	        contentPane.add(chooseAsaButton,c);
	        
	        chooseAsaButton.addActionListener(new ActionListener() { 
	        	public void actionPerformed(ActionEvent ae){ 
	        		chooseAsaButton.getModel().setPressed(true);
	        		voice = "Åsa";
	        	}
	        	});
	        
	        final JButton chooseJesperButton = new JButton("Jesper");
	        chooseJesperButton.setSize(50, 50);
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 1;
	        c.gridy = 2;
	        contentPane.add(chooseJesperButton,c);
	        
	        chooseJesperButton.addActionListener(new ActionListener() { 
	        	public void actionPerformed(ActionEvent ae){ 
	        		chooseJesperButton.getModel().setPressed(true);
	        		voice = "Jesper";
	        	}
	        	});
	        
	        final JButton chooseFridaButton = new JButton("Frida");
	        chooseFridaButton.setSize(50, 50);
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 2;
	        c.gridy = 2;
	        contentPane.add(chooseFridaButton,c);
	        
	        chooseFridaButton.addActionListener(new ActionListener() { 
	        	public void actionPerformed(ActionEvent ae){ 
	        		chooseFridaButton.getModel().setPressed(true);
	        		voice = "Frida";
	        	}
	        	});
	        
	        
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 1;
	        c.gridy = 3;
	        contentPane.add(timeDisplay,c);
	        
	        
	        frame.setContentPane(contentPane);
	        
	        //Display the window.
	        frame.pack();
	        frame.setSize(400,300);
	        frame.setVisible(true);
	 }
	 
	 
	 
	 public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	        new ClockGUI().createAndShowGUI();
	        //new SpeechMaker();	        
	    }
}
