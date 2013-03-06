 	import java.util.Date;
    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    
    public class ClockBackEnd {
    	public ClockBackEnd () {
    	}
		public String getTime() {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			return dateFormat.format(date);
		}
    }