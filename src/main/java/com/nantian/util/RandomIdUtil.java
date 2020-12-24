package com.nantian.util;

import java.util.Date;
import java.util.Random;


public class RandomIdUtil {

	
	/**
	 * 创建25位全局事件跟踪号 evtTranceId
	 * @param date
	 * @return
	 */
    public static String createEvtTranceId(Date date){
        StringBuffer sb = new StringBuffer();
        sb.append(DateUtil.dateToString(date, "yyyyMMddHHmmssSSS"));
        Random random = new Random();
        for(int i = 0; i<8; i++){
            sb.append(random.nextInt(10)); //[0, 9]
        }
        return sb.toString();
    }
    
}
