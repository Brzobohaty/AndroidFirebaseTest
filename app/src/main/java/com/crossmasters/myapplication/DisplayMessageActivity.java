package com.crossmasters.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class DisplayMessageActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private final String pageType = "other";

    @Override
    /**https://developer.android.com/training/basics/firstapp/starting-activity.html*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle params = new Bundle();
        params.putString("screen_name", pageType);
        mFirebaseAnalytics.logEvent("screenview", params);
    }
}
