package com.silencework.silencebarrage.utility;

/**
 * Created by mayongsheng on 16/1/28.
 */
public class TimeLine {
    public static final long ONE_SECOND = 1000;
    public static final long DEFAULT_DURATION = 8*ONE_SECOND;
    public static final long REFRESH_RATE = 16;

    private static boolean isBarrageTimeLineInit = false;

    private static long barragePlayerStartTime;

    public static void init(){
        if(!isBarrageTimeLineInit){
            barragePlayerStartTime = System.currentTimeMillis();
        }else{

        }
    }

    public static long getBarragePlayerStartTime(){
        return barragePlayerStartTime;
    }

    public static long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }
}
