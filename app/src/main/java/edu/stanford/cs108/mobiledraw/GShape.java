package edu.stanford.cs108.mobiledraw;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by emohelw on 2/20/2018.
 */

public class GShape {

    protected float x1,y1,x2,y2, width, height;  //left,upper,right,bottom it follows the drawRect method in canvas
    protected Paint outlinePaint, fillPaint;

    public GShape(float x1,float y1,float x2,float y2, Paint outlinePaint, Paint fillPaint){
        if((x1<=x2 && y1<=y2)){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;

        }else if (x1>x2 && y1>y2) {
            this.x1 = x2;
            this.y1 = y2;
            this.x2 = x1;
            this.y2 = y1;
        }else if (x1>=x2 && y1<=y2){
            this.x1 = x2;
            this.y1 = y1;
            this.x2 = x1;
            this.y2 = y2;
        } else {
            this.x1 = x1;
            this.y1 = y2;
            this.x2 = x2;
            this.y2 = y1;
        }
        width = Math.abs(x1-x2);
        height = Math.abs(y1-y2);

        this.outlinePaint = outlinePaint;
        this.fillPaint = fillPaint;

    }

    public void drawSelf(Canvas canvas){
        //should be overridden by subclasses.
    }
    public void drawSelf(Canvas canvas, Paint selected){
        //should be overridden by subclasses.
    }
    public boolean contains(float x, float y){
        if(x1<=x && x<=x2 && y1<=y && y<=y2) return true;
        return false;
    }

}
