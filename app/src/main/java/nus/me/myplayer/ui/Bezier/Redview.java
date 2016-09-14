package nus.me.myplayer.ui.Bezier;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

import nus.me.myplayer.R;

/**
 * Created by nus on 13/09/16.
 */
public class Redview extends TextView {

    private String htoNum ="0";
    private int htoColor;


    private Paint paint;
    private Rect mBound;

    public Redview(Context context) {
                    this(context,null);
            }

            public Redview(Context context, AttributeSet attrs) {
                this(context, attrs,0);
            }

            public Redview(Context context, AttributeSet attrs, int defStyleAttr) {
                super(context, attrs, defStyleAttr);

                TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Redview,defStyleAttr,0);
                int n = a.getIndexCount();

                for (int i = 0; i < n; i++) {
                    int attr = a.getIndex(i);
                    switch (attr){
                        case  R.styleable.Redview_htonum:
                            htoNum = a.getString(attr);
                            break;
                        case  R.styleable.Redview_htocolor:
                            htoColor = a.getColor(attr,Color.RED);
                            break;

            }
        }
                a.recycle();
                paint = new Paint();
                mBound = new Rect();
                paint.getTextBounds(htoNum,0,htoNum.length(),mBound);
                paint.getTextBounds("1", 0, "1".length(), mBound);
            }


    int parentHeight ;
    int parentWidth;
    int mDefaultHeight;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(30, 30);


    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint.setColor(Color.RED);
        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredWidth()/2,getMeasuredWidth()/2,paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
        paint.setAntiAlias(true);

        super.onDraw(canvas);

    }






}
