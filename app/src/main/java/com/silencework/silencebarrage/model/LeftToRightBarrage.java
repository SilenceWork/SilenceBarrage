package com.silencework.silencebarrage.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.silencework.silencebarrage.displayer.BarrageTextPaint;

/**
 * Created by mayongsheng on 16/1/27.
 */
public class LeftToRightBarrage extends BaseBarrage {

    @Override
    public void drawSelf(Canvas canvas) {
        Paint paint = BarrageTextPaint.getInstance().getTextPaint();
        paint.setTextSize(textSize);
        paint.setColor(color);
        left -=step;
        canvas.drawText(text,left,top,paint);
    }
}
