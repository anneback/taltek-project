import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.applet.*;  
import java.io.*;  
public class TestSound extends JFrame implements ActionListener  
{  
	JButton btn = new JButton("Play Sound");
	File[] wavFiles; 
	AudioClip[] soundList; 
	@SuppressWarnings("deprecation")
	
	public TestSound()  
	{  
		this.wavFiles = new File[2];
		wavFiles[0] = new File("boxing-bell.wav");  
		wavFiles[1] = new File("2_jesper.wav");
		this.soundList = new AudioClip[2];
		
		setSize(300,100);  
		setLocation(400,300);  
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
		JPanel jp = new JPanel();  
		btn.addActionListener(this);  
		jp.add(btn);  
		getContentPane().add(jp);  
		pack();
		try{
			for(int i = 0;i<soundList.length;i++) {
				soundList[i] = Applet.newAudioClip(wavFiles[i].toURL());
			}
		}  
		catch(Exception e){e.printStackTrace();}  
	}
	
	public void actionPerformed(ActionEvent ae){
		for(int i = 0;i<soundList.length;i++) {
			soundList[i].play();
		}
	}
	
	public static void main(String args[]){new TestSound().setVisible(true);} 
}

