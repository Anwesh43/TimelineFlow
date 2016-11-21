package com.anwesome.uiview.timelineflowdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.anwesome.uiview.timelineflow.HorizontalTimelineView;
import com.anwesome.uiview.timelineflow.TimelineObject;
import com.anwesome.uiview.timelineflow.VerticalTimelineView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout container;
    private final int[] resourceFiles = {R.drawable.conte,R.drawable.klopp,R.drawable.wenger,R.drawable.conte,R.drawable.klopp,R.drawable.wenger,R.drawable.conte,R.drawable.klopp,R.drawable.wenger};
    private HorizontalTimelineView horizontalTimelineView;
    private VerticalTimelineView verticalTimelineView;
    private boolean[] flags = {true,true,true,true,false,false,false,false,false};
    private List<TimelineObject> timelineObjects = new ArrayList<>(),timelineObjects2 = new ArrayList<>();
    private String[] titles = {"arsenal home","liverpool away","chelsea away","arsenal away","liverpool home","chelsea away","arsenal away","liverpool away","chelsea home"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (LinearLayout)findViewById(R.id.container);
        for(int i=0;i<resourceFiles.length;i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),resourceFiles[i]);
            TimelineObject timelineObject = new TimelineObject(bitmap,titles[i],flags[i]);
            TimelineObject timelineObject2 = new TimelineObject(bitmap,titles[i],flags[i]);
            timelineObjects.add(timelineObject);
            timelineObjects2.add(timelineObject2);
        }
        horizontalTimelineView = new HorizontalTimelineView(this,timelineObjects);
        horizontalTimelineView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400));
        container.addView(horizontalTimelineView);
        verticalTimelineView = new VerticalTimelineView(this,timelineObjects2);
        verticalTimelineView.setLayoutParams(new LinearLayout.LayoutParams(400,1280));
        container.addView(verticalTimelineView);
        verticalTimelineView.setX(300);
        verticalTimelineView.setY(100);

    }
}
