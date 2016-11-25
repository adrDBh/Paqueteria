package Functions;

import java.sql.Timestamp;
import java.util.Date;

public class TimeStamps {
    public Timestamp getStamps() {
        return new Timestamp(new Date().getTime());
    }
}
