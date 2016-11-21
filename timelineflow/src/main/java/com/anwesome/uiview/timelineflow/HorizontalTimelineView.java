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
public class HorizontalTimelineView extends TimelineView {
//    private int time = 0;
//    private float scrollY = 0,scrollX=0,gapX=0,radius=10,totalX;
//    private List<TimelineObject> timelineObjects = new ArrayList<>();
//    private GestureDetector gestureDetector;
//    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    private int container;
//    private class HorizontalViewGestureListener extends GestureDetector.SimpleOnGestureListener {
//        public boolean onDown(MotionEvent event) {
//            return true;
//        }
//        public boolean onSingleTapUp(MotionEvent event) {
//            return true;
//        }
//        public boolean onScroll(MotionEvent e1,MotionEvent e2,float velx,float vely) {
//            if(e1.getX()>e2.getX()) {
//                scrollX-=Math.abs(velx);
//            }
//            else {
//                scrollX+=Math.abs(velx);
//            }
//            if(scrollX>container/10) {
//                scrollX = container/10;
//            }
//            if(scrollX<-(totalX-container)) {
//                scrollX = -(totalX-container);
//            }
//            postInvalidate();
//            return true;
//        }
//    }
    public HorizontalTimelineView(Context context, List<TimelineObject> timelineObjects) {
        super(context,timelineObjects);

    }
    public float getXDir() {
        return 1;
    }
    public float getYDir() {
        return 0;
    }
    public boolean onTouchEvent(MotionEvent event) {
        return handleTouch(event);
    }
//    public void init(int w,int h) {
//        float initX = w/10;
//        radius = h/4;
//        scrollY = h/4;
//        scrollX = w/10;
//        gapX = w/2-radius-scrollX;
//        container = w;
//        totalX = timelineObjects.size()*gapX;
//        for(TimelineObject timelineObject:timelineObjects) {
//            timelineObject.setX(initX);
//            timelineObject.setY(radius);
//            timelineObject.setR(radius);
//            initX+=gapX;
//        }
//
//    }
//    public void onDraw(Canvas canvas) {
//        if(time == 0) {
//            init(canvas.getWidth(), canvas.getHeight());
//        }
//        canvas.drawColor(Color.WHITE);
//        canvas.save();
//        canvas.translate(scrollX,scrollY);
//        int index = 0;
//        for(TimelineObject timelineObject:timelineObjects) {
//            timelineObject.draw(canvas,paint);
//            if(index != timelineObjects.size()-1) {
//                paint.setColor(Color.parseColor(AppConstants.INCOMPLETE_COLOR));
//                if(timelineObjects.get(index+1).isCompleted()) {
//                    paint.setColor(Color.parseColor(AppConstants.COMPLETE_COLOR));
//                }
//                canvas.drawLine(timelineObject.getX()+radius,radius,timelineObject.getX()+gapX-radius,radius,paint);
//            }
//            index++;
//
//        }
//        canvas.restore();
//        time++;
//
//    }
//    public boolean onTouchEvent(MotionEvent event) {
//        return gestureDetector.onTouchEvent(event);
//    }

}
