package edu.stanford.cs108.mobiledraw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: document your custom view class.
 */
public class DrawingView extends View implements View.OnClickListener {


    private Paint redOutlinePaint;
    private Paint blueOutlinePaint;
    private Paint whiteFillPaint;
    private int viewWidth, viewHeight;
    private float x, y;   //represent the start upper left coordinates of a shape
    private float currX, currY;  //updates (x,y) as the user drag till he lift his finger.
    private float rectWidth , rectHeight;
    private List<GShape> shapes = new ArrayList<>();
    private GRect gRect;
    private GOval gOval;
    GShape selectedShape;
    GShape deletedShape;

    //Control from other views
    private RadioGroup options;
    private int selection;
    private EditText xValue, yValue, width, height;
    private Button update;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        redOutlinePaint = new Paint();
        redOutlinePaint.setColor(Color.RED); 
        redOutlinePaint.setStyle(Paint.Style.STROKE); 
        redOutlinePaint.setStrokeWidth(5.0f);

        whiteFillPaint = new Paint();
        whiteFillPaint.setColor(Color.WHITE);

        blueOutlinePaint = new Paint();
        blueOutlinePaint.setColor(Color.BLUE);
        blueOutlinePaint.setStyle(Paint.Style.STROKE);
        blueOutlinePaint.setStrokeWidth(15.0f);

    }
    public void onClick(View v){
        if(selectedShape == null) return;
        float xEditText = Float.valueOf(xValue.getText().toString());
        float yEditText = Float.valueOf(yValue.getText().toString());
        float widthEditText = Float.valueOf(width.getText().toString());
        float heightEditText = Float.valueOf(height.getText().toString());
        selectedShape.x1 = xEditText;
        selectedShape.y1 = yEditText;
        selectedShape.width = widthEditText;
        selectedShape.height = heightEditText;
        selectedShape.x2 = widthEditText + xEditText;
        selectedShape.y2 = heightEditText + yEditText;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w,h,oldw,oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        selection = options.getCheckedRadioButtonId();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                selectedShape = null;
                if(selection == R.id.select){
                    if(!shapes.isEmpty()) {
                        for (GShape sh : shapes) {
                            if (sh.contains(x, y)) selectedShape = sh;
                        }
                    }
                }
                if(selection == R.id.erase){
                    if(!shapes.isEmpty()) {
                        for (GShape sh : shapes) {
                            if (sh.contains(x, y)) deletedShape = sh;
                        }
                        shapes.remove(deletedShape);
                    }

                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                currX = event.getX();
                currY = event.getY();
                if(selection == R.id.rect)
                    gRect = new GRect(x,y,currX,currY,redOutlinePaint,whiteFillPaint);
                if(selection == R.id.oval)
                    gOval = new GOval(x,y,currX,currY,redOutlinePaint,whiteFillPaint);
                //rectWidth = currX - x;
                //rectHeight = currY - y;
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                currX = event.getX();
                currY = event.getY();
                if(currX == x && currY == y) break;
                if(selection == R.id.rect) {
                    gRect = new GRect(x, y, currX, currY, redOutlinePaint,whiteFillPaint);
                    shapes.add(gRect);
                    selectedShape = gRect;
                    gRect = null;
                }
                if(selection == R.id.oval) {
                    gOval = new GOval(x, y, currX, currY, redOutlinePaint,whiteFillPaint);
                    shapes.add(gOval);
                    selectedShape = gOval;
                    gOval = null;
                }

                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        options = (RadioGroup)((Activity) getContext()).findViewById(R.id.menu);
        xValue = (EditText) ((Activity) getContext()).findViewById(R.id.xValue);
        yValue = (EditText) ((Activity) getContext()).findViewById(R.id.yValue);
        width = (EditText) ((Activity) getContext()).findViewById(R.id.widthValue);
        height = (EditText) ((Activity) getContext()).findViewById(R.id.heightValue);
        update = (Button)((Activity) getContext()).findViewById(R.id.update);
        update.setOnClickListener(this);
        selection = options.getCheckedRadioButtonId();
        if(!shapes.isEmpty()){
            for (GShape sh : shapes) {
                sh.drawSelf(canvas);
            }
        }
        if(selection == R.id.rect && gRect != null) gRect.drawSelf(canvas);
        if(selection == R.id.oval && gOval != null) gOval.drawSelf(canvas);

        if((selection == R.id.select && selectedShape != null) || selectedShape != null) {
            selectedShape.drawSelf(canvas, blueOutlinePaint);
            xValue.setText(String.valueOf(selectedShape.x1));
            yValue.setText(String.valueOf(selectedShape.y1));
            width.setText(String.valueOf(selectedShape.width));
            height.setText(String.valueOf(selectedShape.height));
        }else{
            xValue.setText("");
            yValue.setText("");
            width.setText("");
            height.setText("");
        }

    }

}
