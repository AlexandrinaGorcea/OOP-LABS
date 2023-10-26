package date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FormatOfTheTime {

    public static String formatTimestamp(long timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Timestamp(timestamp));
    }
}
