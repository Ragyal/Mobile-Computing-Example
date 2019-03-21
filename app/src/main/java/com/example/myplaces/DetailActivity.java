package com.example.myplaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    public static final String EXTRA_PLACE_NAME = "EXTRA_PLACE_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String placeName = intent.getStringExtra(EXTRA_PLACE_NAME);

        TextView textView = findViewById(R.id.place_textView);
        textView.setText(placeName);
    }
}
