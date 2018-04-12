package edu.stanford.cs108.mobiledraw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by emohelw on 2/20/2018.
 */

public class GRect extends GShape {

    public GRect(float x1,float y1,float x2,float y2, Paint outlinePaint, Paint fillPaint){
        super(x1, y1, x2, y2, outlinePaint, fillPaint);
    }

    @Override
    public void drawSelf(Canvas canvas){
        canvas.drawRect(x1,y1,x2,y2,fillPaint);
        canvas.drawRect(x1,y1,x2,y2,outlinePaint);
    }
    public void drawSelf(Canvas canvas, Paint selectedOutline){
        //canvas.drawRect(x1,y1,x2,y2,fillPaint);
        canvas.drawRect(x1,y1,x2,y2,selectedOutline);
    }

}
