package com.anwesome.uiview.timelineflow;

import android.content.Context;

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
}
