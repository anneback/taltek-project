import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
    
    public class ClockBackEnd {
    	private int hour;
    	private int minute;
    	private ArrayList<String> audioFiles; 
    	private String voice;
    	
    	public ClockBackEnd () {
    		this.voice = "Jesper";
    	}
    	
		public String getTime(String inputVoice) throws UnsupportedAudioFileException, IOException, LineUnavailableException {	
			if(!voice.equals(null)){
				voice = inputVoice;
			}
			
			audioFiles = new ArrayList<String>();
    		audioFiles.add(""+voice+"-wav/klockan-ar.wav");
    		
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    		Calendar cal = Calendar.getInstance();
    		
    		this.hour = cal.get(Calendar.HOUR_OF_DAY);
    		this.minute = cal.get(Calendar.MINUTE);
    		
    		analyseMinute();
    		analyseHour();
    		analyseTimeOfDay();
    		
    		SpeechMaker sm = new SpeechMaker(audioFiles);
    		
			return dateFormat.format(cal.getTime());
		}
		
		public void analyseMinute() {
			
			
			if((minute >= 3 && minute <5) || (minute >= 8 && minute <10) || (minute >= 13 && minute <15) 
					|| (minute >= 18 && minute <20) || (minute >= 23 && minute <25) || (minute >= 28 && minute <30)
					|| (minute >= 33 && minute <35) || (minute >= 38 && minute <40) || (minute >= 43 && minute <45)
					|| (minute >= 48 && minute <50) || (minute >= 53 && minute <55) || (minute >= 58 && minute <=59)) {
				String str = ""+voice+"-wav/";
				str += "nastan";
				str += ".wav";
				audioFiles.add(str);
			}
			else if((minute >= 1 && minute <3) || (minute >= 6 && minute <8) || (minute >= 11 && minute <13) 
					|| (minute >= 16 && minute <18) || (minute >= 21 && minute <23) || (minute >= 26 && minute <28)
					|| (minute >= 31 && minute <33) || (minute >= 36 && minute <38) || (minute >= 41 && minute <43)
					|| (minute >= 46 && minute <48) || (minute >= 51 && minute <53) || (minute >= 56 && minute <=58)) {
				String str = ""+voice+"-wav/";
				str += "lite-efter";
				str += ".wav";
				audioFiles.add(str);
			}
			
			String str = ""+voice+"-wav/";
			
			if(minute >= 3 && minute <= 7) {
				str += "fem-over";
			} else if(minute >= 8 && minute <= 12) {
				str += "tio-over";
			} else if(minute >= 13 && minute <= 17) {
				str += "kvart-over";
			} else if(minute >= 18 && minute <= 22) {
				str += "tjugo-over";
			} else if(minute >= 23 && minute <= 27) {
				str += "fem-i-halv";
			} else if(minute >= 28 && minute <= 32) {
				str += "halv";
				hour++;
			} else if(minute >= 33 && minute <= 37) {
				str += "fem-over-halv";
				hour++;
			} else if(minute >= 38 && minute <= 42) {
				str += "tjugo-i";
				hour++;
			} else if(minute >= 43 && minute <= 47) {
				str += "kvart-i";
				hour++;
			} else if(minute >= 48 && minute <= 52) {
				str += "tio-i";
				hour++;
			} else if(minute >= 53 && minute <= 57) {
				str += "fem-i";
				hour++;
			}
			
			str += ".wav";
			audioFiles.add(str);
		}
		
		
		public void analyseHour() {
			String str = ""+voice+"-wav/";
			if(hour <= 12) {
				str += hour;
			} else {
				str+= (hour-12);
			}
			str += ".wav";
			audioFiles.add(str);
		}
				
		public void analyseTimeOfDay(){
			String str = ""+voice+"-wav/";
			if(hour>=4 && hour<9){
				str += "morgonen";
			}
			else if(hour>=9 && hour<12){
				str += "fm";
			}
			else if(hour>=12 && hour<14){
				str += "dagen";
			}
			else if(hour>=14 && hour<17){
				str += "em";
			}
			else if(hour>=17 && hour<23){
				str += "kvallen";
			}
			else{
				str += "natten";
			}
			str += ".wav";
			audioFiles.add(str);
		}
		
    }