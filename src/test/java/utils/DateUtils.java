package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", DateUtils.class.getSimpleName());

    private DateUtils(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    private static final Calendar CALENDAR = Calendar.getInstance();

    public static Date getDateFrom(int year, int month, int day){
        CALENDAR.set(year, month, day);
        return CALENDAR.getTime();
    }
}
