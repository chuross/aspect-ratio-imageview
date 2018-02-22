package dev.chuross.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setImageViewSize(R.id.img_aspect_image_1, R.id.txt_size_1);
        setImageViewSize(R.id.img_aspect_image_2, R.id.txt_size_2);
        setImageViewSize(R.id.img_aspect_image_3, R.id.txt_size_3);
        setImageViewSize(R.id.img_aspect_image_4, R.id.txt_size_4);
        setImageViewSize(R.id.img_aspect_image_5, R.id.txt_size_5);
        setImageViewSize(R.id.img_aspect_image_6, R.id.txt_size_6);
        setImageViewSize(R.id.img_aspect_image_7, R.id.txt_size_7);
        setImageViewSize(R.id.img_aspect_image_8, R.id.txt_size_8);
        setImageViewSize(R.id.img_aspect_image_9, R.id.txt_size_9);
        setImageViewSize(R.id.img_aspect_image_10, R.id.txt_size_10);
    }

    private void setImageViewSize(int imageViewId, int sizeTextViewId) {
        final TextView text = (TextView) findViewById(sizeTextViewId);
        final View imageView = findViewById(imageViewId);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                text.setText(String.format("w:%d x h:%d", imageView.getWidth(), imageView.getHeight()));
            }
        });
    }
}
