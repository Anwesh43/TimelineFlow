package com.anwesome.uiview.timelineflow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 21/11/16.
 */
public class TimelineObject {

    private Bitmap bitmap;
    private String title;
    private float x;
    private float y;

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    private float r;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private boolean completed = false;
    public TimelineObject( Bitmap bitmap,String title,boolean completed) {
        this.bitmap = bitmap;
        this.completed = completed;
        this.title = title;
    }
    public boolean isCompleted() {
        return this.completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    public int hashCode() {
        return bitmap.hashCode()+(completed?1:0)+title.hashCode();
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        Path path = new Path();
        path.addArc(new RectF(x-r,y-r,x+r,y+r),0,360);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        if(completed) {
            paint.setColor(Color.parseColor("#FFEA00"));
        }
        else {
            paint.setColor(Color.parseColor(AppConstants.INCOMPLETE_COLOR));
        }
        canvas.drawPath(path,paint);
        canvas.clipPath(path);
        if(bitmap!=null) {
            if(!completed) {
                paint.setAlpha(150);
            }
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(x - r, y - r, x + r, y + r), paint);
        }
        paint.setAlpha(255);
        paint.setColor(Color.WHITE);
        if(title!=null && !title.trim().equals("")) {
            paint.setTextSize(r/3);
            float ftSize = paint.measureText(title);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawText(title,x-ftSize/2,y-ftSize/2,paint);
        }
        canvas.restore();
    }
}
