package com.anwesome.uiview.timelineflow;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 21/11/16.
 */
public class TimelineView extends View {

    private int time = 0;
    private float scrollY = 0,scrollX=0,gapX=0,radius=10,totalX = 0,gapY=0,totalY = 0;
    private List<TimelineObject> timelineObjects = new ArrayList<>();
    private GestureDetector gestureDetector;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int container;
    public void handleScrollX(MotionEvent e1,MotionEvent e2,float velx,float vely) {
        if(e1.getX()>e2.getX()) {
            scrollX-=Math.abs(velx);
        }
        else {
            scrollX+=Math.abs(velx);
        }
        if(scrollX>container/10) {
            scrollX = container/10;
        }
        if(scrollX<-(totalX-container)) {
            scrollX = -(totalX-container);
        }
        postInvalidate();
    }
    public void handleScrollY(MotionEvent e1,MotionEvent e2,float velx,float vely) {
        if(e1.getY()>e2.getY()) {
            scrollY-=Math.abs(vely);
        }
        else {
            scrollY+=Math.abs(vely);
        }
        if(scrollY>container/10) {
            scrollY = container/10;
        }
        if(scrollY<-(totalY-container)) {
            scrollY = -(totalY-container);
        }
        postInvalidate();
    }
    private class TimelineViewGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent event) {
            return true;
        }
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
        public boolean onScroll(MotionEvent e1,MotionEvent e2,float velx,float vely) {
            if(getXDir() == 1) {
                handleScrollX(e1, e2, velx, vely);
            }
            else if(getYDir() == 1) {
                handleScrollY(e1,e2,velx,vely);
            }
            return true;
        }
    }
    public float getXDir() {
        return 0;
    }
    public float getYDir() {
        return 0;
    }
    public TimelineView(Context context,List<TimelineObject> timelineObjects) {
        super(context);
        this.timelineObjects = timelineObjects;
        this.gestureDetector = new GestureDetector(context,new TimelineViewGestureListener());
    }
    public void init(int w,int h) {
        float initX = w/10;
        float initY = 0;
        radius = h/4;
        scrollY = h/4;
        scrollX = w/10;
        container = w;
        if(getYDir() == 1) {
            radius = w/4;
            scrollX = w/4;
            scrollY = h/10;
            container = h;
            initX = 0;
            initY = h/10;

        }
        gapX = (w/2>3*radius+scrollX)?(w / 2 - radius - scrollX) * getXDir():(w-radius-scrollX)*getXDir();
        gapY = (h/2>3*radius+scrollY)?(h/2-radius-scrollY)*getYDir():(h-radius-scrollY)*getYDir();


        totalX = timelineObjects.size()*gapX;
        totalY = timelineObjects.size()*gapY;
        for(TimelineObject timelineObject:timelineObjects) {
            timelineObject.setX(initX*getXDir()+radius*getYDir());
            timelineObject.setY(initY*getYDir()+radius*getXDir());
            timelineObject.setR(radius);
            initX+=gapX;
            initY+=gapY;
        }

    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            init(canvas.getWidth(), canvas.getHeight());
        }
        canvas.drawColor(Color.WHITE);
        canvas.save();
        canvas.translate(scrollX,scrollY);
        int index = 0;
        for(TimelineObject timelineObject:timelineObjects) {
            timelineObject.draw(canvas,paint);
            if(index != timelineObjects.size()-1) {
                paint.setColor(Color.parseColor(AppConstants.INCOMPLETE_COLOR));
                if(timelineObjects.get(index+1).isCompleted()) {
                    paint.setColor(Color.parseColor(AppConstants.COMPLETE_COLOR));
                }
                canvas.drawLine(timelineObject.getX()+radius*getXDir(),timelineObject.getY()+radius*getYDir(),timelineObject.getX()+(gapX-radius)*getXDir(),timelineObject.getY()+(gapY-radius)*getYDir(),paint);
            }
            index++;

        }
        canvas.restore();
        time++;

    }
    protected boolean handleTouch(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }



}
