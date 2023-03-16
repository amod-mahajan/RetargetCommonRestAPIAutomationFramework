package utils;

import java.time.LocalDate;
import java.util.Date;

public class DateUtils {

    public static int getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
