package Functions;

import java.sql.Timestamp;
import java.util.Date;

public class TimeStamps {
    Date dateToday = new Date();
    Timestamp todayStamp = new Timestamp(dateToday.getTime());


    public String getStamps() {
        return new Timestamp(dateToday.getTime()).toString();
    }
}
