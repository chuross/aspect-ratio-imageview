package com.github.chuross;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import dev.chuross.library.R;

public class AspectRatioImageView extends AppCompatImageView {

    private static final int DEFAULT_ASPECT_RATIO = 1;
    private int widthRatio;
    private int heightRatio;

    public AspectRatioImageView(final Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public AspectRatioImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public AspectRatioImageView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if(attrs == null) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView, defStyleAttr, defStyleRes);

        widthRatio = typedArray.getInteger(R.styleable.AspectRatioImageView_ariv_widthRatio, DEFAULT_ASPECT_RATIO);
        heightRatio = typedArray.getInteger(R.styleable.AspectRatioImageView_ariv_heightRatio, DEFAULT_ASPECT_RATIO);

        typedArray.recycle();

        validateRatio(widthRatio);
        validateRatio(heightRatio);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        float sizePerRatio = (float) width / (float) widthRatio;
        int height = Math.round(sizePerRatio * heightRatio);

        setMeasuredDimension(width, height);
    }

    public int getWidthRatio() {
        return widthRatio;
    }

    public void setWidthRatio(int widthRatio) {
        validateRatio(widthRatio);
        this.widthRatio = widthRatio;
    }

    public int getHeightRatio() {
        return heightRatio;
    }

    public void setHeightRatio(int heightRatio) {
        validateRatio(heightRatio);
        this.heightRatio = heightRatio;
    }

    private void validateRatio(int ratio) {
        if(ratio <= 0) {
            throw new IllegalArgumentException("ratio > 0");
        }
    }
}