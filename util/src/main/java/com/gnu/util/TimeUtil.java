package com.gnu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author xuejiawei@lohogames.com on 2017-07-18
 */
public class TimeUtil {
    private static final long DAILY_MILLISECONDS = 24 * 60 * 60 * 1000;

    /**
     * 判断两个时间戳是否处于同一天
     *
     * @param timestamp1 时间戳1
     * @param timestamp2 时间戳2
     *
     * @return true处于同一天, false不处于同一天
     */
    public static boolean checkSameDay(long timestamp1, long timestamp2) {
        // 根据timestamp1计算出那天0点的时间戳，判断timestamp2 > 0点时间戳 + 24 * 60 * 60 * 1000

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(timestamp1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(String.format("begin time of timestamp1 is %s", dateFormat.format(calendar.getTime())));

        return timestamp2 >= calendar.getTimeInMillis() && timestamp2 < calendar.getTimeInMillis() + DAILY_MILLISECONDS;
    }
}
