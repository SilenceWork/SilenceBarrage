package com.silencework.silencebarrage.displayer;

import android.graphics.Paint;

/**
 * Created by mayongsheng on 16/1/27.
 */
public class BarrageTextPaint {

    private static BarrageTextPaint instance = new BarrageTextPaint();
    private Paint textPaint;

    private BarrageTextPaint(){
        textPaint = new Paint();
    }

    public static BarrageTextPaint getInstance(){
        return instance;
    }

    public Paint getTextPaint(){
        return textPaint;
    }

}
