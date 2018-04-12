package edu.stanford.cs108.mobiledraw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;

/**
 * Created by emohelw on 2/20/2018.
 */

public class GOval extends GShape {
    public GOval(float x1,float y1,float x2,float y2, Paint outlinePaint, Paint fillPaint){
        super(x1, y1, x2, y2, outlinePaint, fillPaint);
    }

    @Override
    public void drawSelf(Canvas canvas){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(x1,y1,x2,y2,fillPaint);
            canvas.drawOval(x1,y1,x2,y2,outlinePaint);
        }else {
            RectF rectF = new RectF(x1,y1,x2,y2);
            canvas.drawOval(rectF,fillPaint);
            canvas.drawOval(rectF,outlinePaint);
        }
    }
    public void drawSelf(Canvas canvas, Paint selectedOutline){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //canvas.drawOval(x1,y1,x2,y2,fillPaint);
            canvas.drawOval(x1,y1,x2,y2,selectedOutline);
        }else {
            RectF rectF = new RectF(x1,y1,x2,y2);
            //canvas.drawOval(rectF,fillPaint);
            canvas.drawOval(rectF,selectedOutline);
        }
    }

}
