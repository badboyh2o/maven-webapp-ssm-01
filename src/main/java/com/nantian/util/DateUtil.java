package com.nantian.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static Logger log = LoggerFactory.getLogger(DateUtil.class);
	
	/**
	 * 日期 to String
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String str = simpleDateFormat.format(date);
		return str;
	}
	
	/**
	 * String to 日期
	 * @param dateString
	 * @param pattern
	 * @return
	 * @throws ParseException 
	 */
	public static Date stringToDate (String dateString, String pattern) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date;
		date = simpleDateFormat.parse(dateString);
		return date;
	}
	

	/**
	 * 获取两个日期相差几个月,仅比较月份
	 * 
	 *     如果开始日期大于结束日期，抛出运行时异常
	 * 
	 * @param dateStart
	 * @return
	 */
	public static int getMonthInterval(Date dateStart, Date dateEnd) {
	    // 抛出运行时异常
		if(dateStart == null || dateEnd == null || dateStart.after(dateEnd)){
		    throw new IllegalArgumentException("计算两个日期月份间隔，结束日期小于开始日期");
		}
		int yearStart = Integer.parseInt(dateToString(dateStart, "yyyyMM").substring(0, 4));
		int monthStart = Integer.parseInt(dateToString(dateStart, "yyyyMM").substring(4));
		int yearEnd = Integer.parseInt(dateToString(dateEnd, "yyyyMM").substring(0, 4));
		int monthEnd = Integer.parseInt(dateToString(dateEnd, "yyyyMM").substring(4));
		int yearInterval = yearEnd - yearStart;
		if(yearInterval == 0){
			return monthEnd - monthStart;
		} else {
			//return (yearEnd - (yearStart + 1)) * 12 + (12 - monthStart) + monthEnd;
			return (yearEnd - yearStart) * 12 + monthEnd - monthStart;
		}
	}
	
	/**
	 * 根据生日获取年龄
	 * @param birthday
	 * @return
	 */
    public static int getAgeByBirth(Date birthday){        
        Calendar cal = Calendar.getInstance();
        Calendar bir = Calendar.getInstance();
        bir.setTime(birthday);
        
        // 抛出运行时异常
        if(cal.before(bir)){
            throw new IllegalArgumentException("生日小于当前时间");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayNow = cal.get(Calendar.DAY_OF_MONTH);
        
        int yearBirth = bir.get(Calendar.YEAR);
        int monthBirth = bir.get(Calendar.MONTH);
        int dayBirth = bir.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        /*如果出当前月小与出生月，或者当前月等于出生月但是当前日小于出生日，那么年龄age就减一岁*/
        if(monthNow < monthBirth || (monthNow == monthBirth && dayNow < dayBirth)){
            age--;
        }
        return age;
    }
	
    
	/**
	 * 计算两个日期之间相差多少天, 向下取整
	 * @param birthday
	 * @return
	 */
    public static int getDateInterval(Date before, Date later){        
        Calendar bef = Calendar.getInstance();
        Calendar lat = Calendar.getInstance();
        
        bef.setTime(before);
        lat.setTime(later);
        
        // 抛出运行时异常
        if(lat.before(bef)){
            throw new IllegalArgumentException("计算两个日期之间相差多少天，参数不合法");
        }
        int date = (int) ((lat.getTimeInMillis() - bef.getTimeInMillis())/(1000 * 60 * 60 * 24));
        
        return date;
    }
    
    /**
     * 获取距离指定日期的 前/后 n 天的日期
     * @param date
     * @param n	负数时表示前n天，正数表示后n天
     * @return
     */
    public static Date getSpecificDateByDayCount(Date theDate, int n){        
        Calendar theCal = Calendar.getInstance();
        theCal.setTime(theDate);
        theCal.add(Calendar.DATE, n);
        Date resultDate = theCal.getTime();
        return resultDate;
    }
    
    /**
     * 获取距离指定日期的 前/后 n 个月的日期
     * @param theDate
     * @param n
     * @return
     */
    public static Date getSpecificDateByMonthCount(Date theDate, int n){        
        Calendar theCal = Calendar.getInstance();
        theCal.setTime(theDate);
        theCal.add(Calendar.MONTH, n);
        Date resultDate = theCal.getTime();
        return resultDate;
    }
    
}
