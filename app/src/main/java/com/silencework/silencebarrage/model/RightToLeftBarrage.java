package com.silencework.silencebarrage.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.silencework.silencebarrage.displayer.BarrageTextPaint;
import com.silencework.silencebarrage.utility.ScreenConfig;
import com.silencework.silencebarrage.utility.TimeLine;

/**
 * Created by mayongsheng on 16/1/28.
 */
public class RightToLeftBarrage extends BaseBarrage {

    @Override
    public void drawSelf(Canvas canvas) {
        if (isShowing()) {
//            Log.i("SilenceBarrage","isshow = true");
            Paint paint = BarrageTextPaint.getInstance().getTextPaint();
            paint.setTextSize(textSize);
            paint.setColor(color);
            left = caculateLeft();
            Log.i("SilenceBarrage","draw text="+text+"  textSize="+textSize+"   color="+color+"     left="+left);
            int tempTop =ScreenConfig.getInstance().getScreenHeight()/2;
            canvas.drawText(text, left, tempTop, paint);
        }
    }

    public int caculateLeft() {
        int totalLength = width + ScreenConfig.getInstance().getScreenWidth();
        long spendTime = TimeLine.getCurrentTimeMillis() - startShowTime;
        if (spendTime > 0 && spendTime < duration) {
            float offset = spendTime*1.0f/duration;
            return (int) (ScreenConfig.getInstance().getScreenWidth() - totalLength*offset);
        }

        return ScreenConfig.getInstance().getScreenWidth();
    }
}
