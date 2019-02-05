package com.example.android.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView mReceivedMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mReceivedMessageTextView = findViewById(R.id.received_message_textView);

        Intent intent = getIntent();
        String text = intent.getStringExtra("message");
        mReceivedMessageTextView.setText(text);

    }
}
