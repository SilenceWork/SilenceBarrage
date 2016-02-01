package com.silencework.silencebarrage.utility;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by mayongsheng on 16/1/29.
 */
public class ScreenConfig {
    private static ScreenConfig instance;

    private int screenWidth;
    private int screenHeight;
    private boolean hasMeasured;

    private ScreenConfig(){}

    public static ScreenConfig getInstance(){
        if(instance == null){
            instance = new ScreenConfig();
        }

        return instance;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        this.screenWidth = width;
        this.screenHeight = height;
        Log.i("SilenceBarrage","ScreenConfig onMeasure width="+width+"  height="+height);
        this.hasMeasured = true;
    }

    public int getScreenHeight() {
        if(!hasMeasured){
            throw new IllegalStateException("ScreenConfig onMeasure() has not invoked in BarrageView s onMeasure");
        }
        return screenHeight;
    }

    public int getScreenWidth() {
        if(!hasMeasured){
            throw new IllegalStateException("ScreenConfig onMeasure() has not invoked in BarrageView s onMeasure");
        }
        return screenWidth;
    }

}
