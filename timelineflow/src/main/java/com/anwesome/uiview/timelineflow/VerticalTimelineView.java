package com.anwesome.uiview.timelineflow;

import android.content.Context;
import android.view.MotionEvent;

import java.util.List;

/**
 * Created by anweshmishra on 21/11/16.
 */
public class VerticalTimelineView extends TimelineView {
    public VerticalTimelineView(Context context, List<TimelineObject> timelineObjects) {
        super(context,timelineObjects);
    }
    public float getYDir() {
        return 1;
    }
    public float getXDir() {
        return 0;
    }
    public boolean onTouchEvent(MotionEvent event) {
        return handleTouch(event);
    }
}
