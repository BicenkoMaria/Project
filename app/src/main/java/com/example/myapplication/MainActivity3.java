package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;


public class MainActivity3 extends AppCompatActivity {

    private SubsamplingScaleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageView = findViewById(R.id.imageView3);
        imageView.setImage(ImageSource.resource(R.drawable.one));

        imageView = findViewById(R.id.imageView4);
        imageView.setImage(ImageSource.resource(R.drawable.two));

        imageView = findViewById(R.id.imageView5);
        imageView.setImage(ImageSource.resource(R.drawable.three));

        imageView = findViewById(R.id.imageView6);
        imageView.setImage(ImageSource.resource(R.drawable.four));

        imageView = findViewById(R.id.imageView7);
        imageView.setImage(ImageSource.resource(R.drawable.five));

        imageView = findViewById(R.id.imageView8);
        imageView.setImage(ImageSource.resource(R.drawable.six));

        imageView = findViewById(R.id.imageView9);
        imageView.setImage(ImageSource.resource(R.drawable.seven));
    }

}