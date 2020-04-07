package com.vic.sb11.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 日期工具类
 * @author Victor
 * date: 2019/7/22 13:38
 */
public class DateUtils {

    /**
     * 指定date加seconds秒
     * @param date
     * @param seconds
     * @return
     */
    public static Date plusSeconds(Date date, long seconds) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        LocalDateTime newLocalDateTime = localDateTime.plusSeconds(seconds);

        ZonedDateTime zdt = newLocalDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

}
