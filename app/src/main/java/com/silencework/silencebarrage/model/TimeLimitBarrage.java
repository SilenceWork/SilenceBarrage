package com.silencework.silencebarrage.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.silencework.silencebarrage.displayer.BarrageTextPaint;
import com.silencework.silencebarrage.utility.TimeLine;

/**
 * Created by mayongsheng on 16/1/28.
 */
public class TimeLimitBarrage extends BaseBarrage {
    private static final long DEFAULT_DURATION = 3000;
    private long duration = DEFAULT_DURATION;

    @Override
    public void drawSelf(Canvas canvas) {

    }
}
