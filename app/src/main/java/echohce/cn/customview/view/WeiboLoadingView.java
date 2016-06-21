package echohce.cn.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lin on 2016/6/21.
 */
public class WeiboLoadingView extends View {
    public WeiboLoadingView(Context context) {
        this(context, null);
    }

    public WeiboLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private Paint mPaintCircleOuter;
    private Paint mPaintCircleInner;

    private float mWidth;
    private float mHeight;
    private float mRadius;
    private RectF mOval;

    // 初始化画笔
    private void init(Context context, AttributeSet attrs) {
        mPaintCircleOuter = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircleOuter.setStyle(Paint.Style.STROKE);
        mPaintCircleOuter.setStrokeWidth(3F);
        mPaintCircleOuter.setColor(Color.parseColor("#bfffffff"));

        mPaintCircleInner = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircleInner.setColor(Color.parseColor("#bfffffff"));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        mRadius = Math.min(mWidth / 2, mHeight / 2) - 6;
        mOval = new RectF(-mRadius + 9, -mRadius + 9, mRadius - 9, mRadius - 9);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth/2,mHeight/2);
        canvas.drawCircle(0, 0, mRadius, mPaintCircleOuter);
        canvas.drawArc(mOval, -90f, mSweepAngel,true,mPaintCircleInner);
    }
    private float mSweepAngel;

    public void setProgress(int progess){
        mSweepAngel = (float) (progess / 100.0 * 360);
        invalidate();
    }
}
