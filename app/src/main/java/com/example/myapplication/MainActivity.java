package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;



public class MainActivity extends AppCompatActivity {

    private SubsamplingScaleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.setImage(ImageSource.resource(R.drawable.act11));

    }

    public void ClickOne (View one){

        TextView password = findViewById(R.id.editTextTextPassword);
        TextView email = findViewById(R.id.editTextTextEmailAddress);

        Resources res = getResources();
        String[] emails = res.getStringArray(R.array.emails);
        String[] passwords = res.getStringArray(R.array.passwords);

        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        boolean flag = true;

        for(int i = 0; i < emails.length && flag; i++) {
            String string1 = emails[i];
            if (emailText.equals(string1)) {
                String string2 = passwords[i];
                if (passwordText.equals(string2)) {
                    Intent intent = new Intent(this, MainActivity2.class);
                    startActivity(intent);
                    flag = false;
                } else {
                    password.setTextColor(Color.RED);
                }
            } else {
                email.setTextColor(Color.RED);
                password.setTextColor(Color.RED);
            }
        }
    }

    public void ClickTwo (View one){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

}









