package com.silencework.silencebarrage.model;

import android.graphics.Canvas;

/**
 * Created by mayongsheng on 16/1/27.
 */
public interface IBarrage {
    void onMeasure();
    void onLayout();
    void drawSelf(Canvas canvas);
    boolean isShowing();
}
