package util;

import java.sql.Timestamp;

/**
 * 时间相关的工具类
 */
public class ErwinSmithTime {

    /**
     * 时间方法，返回过了length天后的TimeStamp时间
     * @param startTime
     * @param length
     * @return
     */
    public static Timestamp computeEndTime(Timestamp startTime, int length){
        Timestamp endTime = new Timestamp(startTime.getTime() + (length*1000*60*60*24));
        return endTime;
    }
}
