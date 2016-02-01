package com.silencework.silencebarrage.model;

import com.silencework.silencebarrage.utility.TimeLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayongsheng on 16/1/28.
 */
public class BarrageCollection {
    private List<IBarrage> barrageList = new ArrayList<IBarrage>();

    public void addBarrage(IBarrage barrage){
        barrageList.add(barrage);
    }

    public List<IBarrage> getCurrentDisplayBarrages(){
        long currentTime = TimeLine.getCurrentTimeMillis();
        List<IBarrage> currentDisplayBarrages = new ArrayList<IBarrage>();
        final int length = barrageList.size();
        for(int i = 0;i<length;i++){
            if(barrageList.get(i).isShowing()){
                currentDisplayBarrages.add(barrageList.get(i));
            }
        }

        return currentDisplayBarrages;
    }
}
