package com.anwesome.uiview.timelineflowdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.anwesome.uiview.timelineflow.HorizontalTimelineView;
import com.anwesome.uiview.timelineflow.TimelineObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout container;
    private final int[] resourceFiles = {R.drawable.conte,R.drawable.klopp,R.drawable.wenger,R.drawable.conte,R.drawable.klopp,R.drawable.wenger,R.drawable.conte,R.drawable.klopp,R.drawable.wenger};
    private HorizontalTimelineView horizontalTimelineView;
    private boolean[] flags = {true,true,true,true,false,false,false,false,false};
    private List<TimelineObject> timelineObjects = new ArrayList<>();
    private String[] titles = {"arsenal home","liverpool away","chelsea away","arsenal away","liverpool home","chelsea away","arsenal away","liverpool away","chelsea home"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (LinearLayout)findViewById(R.id.container);
        for(int i=0;i<resourceFiles.length;i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),resourceFiles[i]);
            TimelineObject timelineObject = new TimelineObject(bitmap,titles[i],flags[i]);
            timelineObjects.add(timelineObject);
        }
        horizontalTimelineView = new HorizontalTimelineView(this,timelineObjects);
        horizontalTimelineView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300));
        container.addView(horizontalTimelineView);
    }
}
