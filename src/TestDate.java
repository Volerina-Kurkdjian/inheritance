import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a Z");

    public static void main(String[] args) {

        System.out.println("Current date time in local is: " + new Date());

        System.out.println("Current date in UTC is: " + getCurrentDateUTC());

        System.out.println("\n=======================Converting a String in a particular format to date Object=========================\n");

        String scheduledDateUtcString = "24-Feb-2016 04:19:00 PM GMT";

        System.out.println("Date Object for string: " + scheduledDateUtcString + " after converting to UTC is " +  getUtcDateFromUtcString(scheduledDateUtcString));

    }


    /**
     * Returns a Date object with the current date/time but in UTC timezone
     *
     * @return Current date in UTC
     */
    public static Date getCurrentDateUTC() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        return c.getTime();
    }

    public static Date getUtcDateFromUtcString(String utcDateString) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        try {
            calendar.setTime(dateFormat.parse(utcDateString));
        } catch (ParseException exception) {
            System.out.println("Parse exception while parsing date: " + utcDateString);
        }
        return calendar.getTime();
    }

    public static String formatDateToString(Date date, String format,
                                            String timeZone) {//https://www.digitalocean.com/community/tutorials/how-to-convert-java-date-into-specific-timezone-format
        // null check    https://mkyong.com/java/java-convert-date-and-time-between-timezone/
        if (date == null) return null;
        // create SimpleDateFormat object with input format
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // default system timezone if passed null or empty
        if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
            timeZone = Calendar.getInstance().getTimeZone().getID();
        }
        // set timezone to SimpleDateFormat
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        // return Date in required format with timezone as String
        return sdf.format(date);
    }
}
