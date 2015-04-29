package dev.chuross.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AspectRatioImageView extends ImageView {

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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AspectRatioImageView(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
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
        int aspectRatio = calculateAspectRatio(widthRatio, heightRatio);

        int adjustedWidthRatio = widthRatio / aspectRatio;
        int adjustedHeightRatio = heightRatio / aspectRatio;

        int width = getMeasuredWidth();
        int sizePerRatio = Math.round(width / adjustedWidthRatio);
        int height = sizePerRatio * adjustedHeightRatio;

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

    private static int calculateAspectRatio(int width, int height) {
        int max;
        int min;
        if(width > height) {
            max = width;
            min = height;
        } else {
            max = height;
            min = width;
        }
        if(max <= 0 || min <= 0) {
            return 0;
        }
        int result = 0;
        int i = 1;
        while(i > 0) {
            if(max % min == 0) {
                result = min;
                break;
            }
            max = max % min;
            if(min % max == 0) {
                result = max;
                break;
            }
            min = min % max;
        }
        return result;
    }
}