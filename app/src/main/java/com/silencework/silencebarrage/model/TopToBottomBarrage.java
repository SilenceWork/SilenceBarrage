package com.silencework.silencebarrage.model;

import android.graphics.Canvas;

import com.silencework.silencebarrage.displayer.BarrageTextPaint;
import com.silencework.silencebarrage.utility.ScreenConfig;

/**
 * Created by mayongsheng on 16/1/28.
 */
public class TopToBottomBarrage extends TimeLimitBarrage {

    @Override
    public void drawSelf(Canvas canvas) {
        if(isShowing()) {
            int screenWidth = ScreenConfig.getInstance().getScreenWidth();
            int screenHeight = ScreenConfig.getInstance().getScreenHeight();
            int barrageWidth = width;
            int barrageHeight = height;
            int top = 200;
            int left = (screenWidth - barrageWidth) / 2;
            canvas.drawText("你好，我是弹幕君，我显示在上面", left, top, BarrageTextPaint.getInstance().getTextPaint());

        }
    }
}
