import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.*;



public class SpeechMaker {

	public SpeechMaker() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		playSpeech();
	}

	public void playSpeech() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File sample1 = new File("Jesper-wav/fem-over_jesper.wav");
		File sample2 = new File("boxing-bell.wav");
		
		FileInputStream fileInputStream = new FileInputStream("boxing-bell.wav");
		
		File fileOut = new File("combined.wav");

		try {
			AudioInputStream audio1 = AudioSystem.getAudioInputStream(sample1);
			AudioInputStream audio2 = AudioSystem.getAudioInputStream(sample2);

			System.out.println(audio2.getFormat().toString());

			//AudioInputStream audioBuild = new AudioInputStream(new SequenceInputStream(audio1, audio2), audio1.getFormat(),
			//		audio1.getFrameLength() + audio2.getFrameLength());

			Clip clip = AudioSystem.getClip();
			clip.open(audio2);
			clip.start();
		}

		catch(UnsupportedAudioFileException uae) {
			System.out.println(uae);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		catch(LineUnavailableException lua) {
			System.out.println(lua);
		}

		/*
		for(int i = 0; i < 5; i++)
		{
		    audioBuild = new AudioInputStream(new SequenceInputStream(audioBuild, AudioSystem.getAudioInputStream(sample2)), audioBuild.getFormat(), audioBuild.getFrameLength() + audio2.getFrameLength());
		}
		 */

		//AudioSystem.write(audioBuild, AudioFileFormat.Type.WAVE, fileOut);
	}
}
