package tjsse20.covid19logisticsblockchain.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateToString(Date date) {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format1.format(date);
    }


}
