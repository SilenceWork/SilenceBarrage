package com.silencework.silencebarrage.model;

import android.graphics.Canvas;

import com.silencework.silencebarrage.utility.TimeLine;

/**
 * Created by mayongsheng on 16/1/27.
 */
public class BaseBarrage implements IBarrage {
    public static final int DEFAULT_STEP = 2;

    protected int left;
    protected int right;
    protected int top;
    protected int bottom;
    protected int paddingLeft;
    protected int paddingRight;
    protected int paddingTop;
    protected int paddingBottom;
    protected int marginBottom;
    protected int marginTop;
    protected int marginLeft;
    protected int marginRight;
    protected String text;
    protected float textSize;
    protected int color;

    protected int width = 200;
    protected int height = 100;
    protected long duration = TimeLine.DEFAULT_DURATION;
    /**
     * the duration between the media start and the barrage ready to display
     */
    protected long startShowTime;

    protected int step = DEFAULT_STEP;

    public void setMargin(int margin) {
        this.marginBottom = margin;
        this.marginLeft = margin;
        this.marginRight = margin;
        this.marginTop = margin;
    }

    public void setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    public void setPadding(int padding) {
        this.paddingLeft = padding;
        this.paddingTop = padding;
        this.paddingRight = padding;
        this.paddingBottom = padding;
    }

    public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getStartShowTime() {
        return startShowTime;
    }

    @Override
    public boolean isShowing() {
        long currentTime = TimeLine.getCurrentTimeMillis();
        long start = startShowTime;
        long end = start + duration;
        return currentTime >= start && currentTime <= end;
    }

    public void setStartShowTime(long startShowTime) {
        this.startShowTime = startShowTime;
    }

    @Override
    public void onMeasure() {

    }

    @Override
    public void onLayout() {

    }

    @Override
    public void drawSelf(Canvas canvas) {

    }
}
