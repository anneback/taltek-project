import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
    
    public class ClockBackEnd {
    	private int hour;
    	private int minute;
    	private ArrayList<String> audioFiles; 
    	
    	public ClockBackEnd () {
    		audioFiles = new ArrayList<String>();
    	}
    	
		public String getTime() {	
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    		Calendar cal = Calendar.getInstance();
    		
    		this.hour = cal.get(Calendar.HOUR_OF_DAY);
    		this.minute = cal.get(Calendar.MINUTE);
    		
			return dateFormat.format(cal.getTime());
		}
		
		public void analyseHour() {
			String str = "";
			if(hour <= 12) {
				str += hour;
			} else {
				str+= (hour-12);
			}
			str += "_jesper.wav";
			audioFiles.add(str);
		}
		
    }