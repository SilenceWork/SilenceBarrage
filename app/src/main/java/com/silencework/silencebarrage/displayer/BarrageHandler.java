package com.silencework.silencebarrage.displayer;

import android.os.Handler;
import android.os.Message;

import com.silencework.silencebarrage.utility.TimeLine;

/**
 * Created by mayongsheng on 16/1/27.
 */
public class BarrageHandler extends Handler {

    private static final int MSG_START = 1;
    private IRefreshListener mListener;
    private RefreshRunnable runnable;

    public BarrageHandler(IRefreshListener listener){
        this.mListener = listener;
        this.runnable = new RefreshRunnable(this,listener);
    }

    @Override
    public void handleMessage(Message msg) {
        int what = msg.what;
        switch(what){
            case MSG_START:
                postDelayed(this.runnable,TimeLine.REFRESH_RATE);
                break;
        }
    }

    public void start(){
        Message message = Message.obtain();
        message.what = MSG_START;
        sendMessage(message);
    }

    public void setListener(IRefreshListener listener){
        this.mListener = listener;
    }

    private static class RefreshRunnable implements Runnable{

        private IRefreshListener listener;
        private Handler mHandler;

        public RefreshRunnable(Handler handler,IRefreshListener listener){
            this.mHandler = handler;
            this.listener = listener;
        }

        @Override
        public void run() {
            if(this.listener!=null){
                this.listener.onRefresh();
            }
            this.mHandler.postDelayed(this, TimeLine.REFRESH_RATE);
        }
    }
}