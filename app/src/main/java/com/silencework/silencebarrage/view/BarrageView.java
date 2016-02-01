package com.silencework.silencebarrage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.silencework.silencebarrage.displayer.BarrageHandler;
import com.silencework.silencebarrage.displayer.IRefreshListener;
import com.silencework.silencebarrage.model.BarrageCollection;
import com.silencework.silencebarrage.model.IBarrage;
import com.silencework.silencebarrage.utility.ScreenConfig;
import com.silencework.silencebarrage.utility.TimeLine;

import java.util.List;

/**
 * Created by mayongsheng on 16/1/27.
 */
public class BarrageView extends View implements IRefreshListener {

    private BarrageHandler mHandler;
    private BarrageCollection barrageCollection;

    public BarrageView(Context context) {
        super(context);
        init();
    }

    public BarrageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BarrageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.mHandler = new BarrageHandler(this);
        this.barrageCollection = new BarrageCollection();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ScreenConfig.getInstance().onMeasure(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<IBarrage> displayingBarrage = this.barrageCollection.getCurrentDisplayBarrages();
        if (displayingBarrage != null && displayingBarrage.size() > 0) {
            final int size = displayingBarrage.size();
            for (int i = 0; i < size; i++) {
                displayingBarrage.get(i).drawSelf(canvas);
            }
        }
    }

    public void start() {
        this.mHandler.start();
    }

    @Override
    public void onRefresh() {
        postInvalidate();
//        Log.i("SilenceBarrage","BarrageView onRefresh time:"+ TimeLine.getCurrentTimeMillis());
    }

    public void addBarrage(IBarrage barrage) {
        this.barrageCollection.addBarrage(barrage);
    }
}
