package com.silencework.silencebarrage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.silencework.silencebarrage.model.BottomToTopBarrage;
import com.silencework.silencebarrage.model.RightToLeftBarrage;
import com.silencework.silencebarrage.model.TopToBottomBarrage;
import com.silencework.silencebarrage.utility.TimeLine;
import com.silencework.silencebarrage.view.BarrageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            BarrageView barrageView = (BarrageView) findViewById(R.id.barrage_view);
            barrageView.start();
            RightToLeftBarrage barrage = new RightToLeftBarrage();
            barrage.setText("我是弹幕君，哈哈哈哈哈哈");
            barrage.setTextSize(50.0f);
            barrage.setColor(getResources().getColor(R.color.colorPrimary));
            barrage.setStartShowTime(TimeLine.getCurrentTimeMillis() + 3000);
            barrageView.addBarrage(barrage);

            TopToBottomBarrage topToBottomBarrage = new TopToBottomBarrage();
            topToBottomBarrage.setTextSize(50.0f);
            topToBottomBarrage.setColor(getResources().getColor(R.color.colorPrimary));
            topToBottomBarrage.setStartShowTime(TimeLine.getCurrentTimeMillis() + 3000);
            barrageView.addBarrage(topToBottomBarrage);

//            BottomToTopBarrage bottomToTopBarrage = new BottomToTopBarrage();
//            bottomToTopBarrage.setTextSize(50.0f);
//            bottomToTopBarrage.setColor(getResources().getColor(R.color.colorPrimary));
//            bottomToTopBarrage.setStartShowTime(TimeLine.getCurrentTimeMillis() + 3000);
//            barrageView.addBarrage(bottomToTopBarrage);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
