package com.anwesome.uiview.timelineflow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 21/11/16.
 */
public class HorizontalTimelineView extends View {
    private float y = 0,x=0,gapX=0,initX = 0,radius=10,totalX;
    private List<TimelineObject> timelineObjects = new ArrayList<>();
    private GestureDetector gestureDetector;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private class HorizontalViewGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent event) {
            return true;
        }
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
        public boolean onScroll(MotionEvent e1,MotionEvent e2,float velx,float vely) {
            if(x>0 && x<totalX) {
                x += velx;
            }
            return true;
        }
    }
    public HorizontalTimelineView(Context context, List<TimelineObject> timelineObjects) {
        super(context);
        this.gestureDetector = new GestureDetector(context,new HorizontalViewGestureListener());
        this.timelineObjects = timelineObjects;
    }
    public void init(int w,int h) {
        initX = w/10;
        radius = w/10;
        gapX = w/2-w/10;
        totalX = timelineObjects.size()*gapX;
    }
    public void onDraw(Canvas canvas) {
        init(canvas.getWidth(),canvas.getHeight());
        canvas.drawColor(Color.WHITE);
        canvas.save();
        canvas.translate(x,y);
        int index = 0;
        for(TimelineObject timelineObject:timelineObjects) {
            timelineObject.draw(canvas,paint,initX,radius,radius);
            index++;
            if(index != timelineObjects.size()-1) {
                canvas.drawLine(initX,radius,initX+gapX,radius,paint);
            }
            initX+=gapX;
        }
        canvas.restore();
    }
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

}
