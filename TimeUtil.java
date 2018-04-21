import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TimeUtil.getCurrentDateTime());
		System.out.println(TimeUtil.getCurrentDate());
		try {
			System.out.println(TimeUtil.hourDiff("20180421170000","20180421150000"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getCurrentDateTime()
	{
		Date dt = new Date(System.currentTimeMillis());
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestring = fm.format(dt);
		return timestring;
	}
	public static String getCurrentDate()
	{
		Date dt = new Date(System.currentTimeMillis());
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		String timestring = fm.format(dt);
		return timestring;
	}
	public static long hourDiff(String strTime1, String strTime2) throws ParseException
	{
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date1 = fm.parse(strTime1);
		Date date2 = fm.parse(strTime2);
		
		long gap = date1.getTime() - date2.getTime();
		
		return gap/60/60/1000;
	}

}
