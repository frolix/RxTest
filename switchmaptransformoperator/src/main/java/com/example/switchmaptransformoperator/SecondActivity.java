package com.example.switchmaptransformoperator;


import android.os.Bundle;
import android.widget.TextView;

import com.example.switchmaptransformoperator.models.Post;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.text);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("post")){
            Post post = getIntent().getParcelableExtra("post");
            assert post != null;
            textView.setText(post.getTitle());
        }
    }
}
