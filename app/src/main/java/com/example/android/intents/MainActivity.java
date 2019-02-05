package com.example.android.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mMessageEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.message_edit_text);

    }

    // take the content of Edit text and send it to details Activity
    public void onExplicitIntentButtonClicked(View view) {
        String text = mMessageEditText.getText().toString();

        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra("message",text);
        startActivity(intent);

    }

    // take the content of the EditText and send it to an email
    public void onImplicitIntentButtonClicked(View view){
        String text = mMessageEditText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, "First Mentoring session");
        intent.putExtra(Intent.EXTRA_TEXT,text);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
