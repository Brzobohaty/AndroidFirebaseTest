package com.crossmasters.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private FirebaseAnalytics mFirebaseAnalytics;
    private final String pageType = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle params = new Bundle();
        params.putString("screen_name", pageType);
        mFirebaseAnalytics.logEvent("screenview", params);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Bundle params = new Bundle();
        params.putString("button", "send");
        mFirebaseAnalytics.logEvent("buttonClick", params);

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
