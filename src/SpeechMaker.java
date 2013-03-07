import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;

import javax.sound.sampled.*;



public class SpeechMaker {
	private AudioInputStream audioBuild;
	private File fileOut;
	private AudioClip sound;
	
	public SpeechMaker(ArrayList<String> audioFiles) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		fileOut = new File("combined.wav");
		playSpeech(audioFiles);
	}

	public void playSpeech(ArrayList<String> audioFiles) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		try {
			AudioInputStream[] audioList = new AudioInputStream[audioFiles.size()];
			for(int i=0; i<audioFiles.size();i++){
				File sample = new File(audioFiles.get(i));
				AudioInputStream audio = AudioSystem.getAudioInputStream(sample);
				audioList[i] = audio;
			}
		
		//File sample1 = new File("Jesper-wav/fem-over_jesper.wav");
		//File sample2 = new File("boxing-bell.wav");
			audioBuild = new AudioInputStream(new SequenceInputStream(audioList[0], audioList[1]), audioList[0].getFormat(),
					audioList[0].getFrameLength() + audioList[1].getFrameLength());
			
			
			for(int i = 2; i < audioList.length; i++)
			{
			    audioBuild = new AudioInputStream(new SequenceInputStream(audioBuild, audioList[i]), 
			    		audioBuild.getFormat(), audioBuild.getFrameLength() + audioList[i].getFrameLength());
			}
			 

		}

		catch(UnsupportedAudioFileException uae) {
			System.out.println(uae);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}

		/*
		for(int i = 0; i < 5; i++)
		{
		    audioBuild = new AudioInputStream(new SequenceInputStream(audioBuild, AudioSystem.getAudioInputStream(sample2)), audioBuild.getFormat(), audioBuild.getFrameLength() + audio2.getFrameLength());
		}
		 */

		AudioSystem.write(audioBuild, AudioFileFormat.Type.WAVE, fileOut);
		
		sound = Applet.newAudioClip(fileOut.toURL());
		
		sound.play();
	}
}
