package com.example.fabiansebban.coursandroid_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button shareButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shareButton = (Button)findViewById(R.id.shareButton);

        //Send a text to another app when click
        shareButton.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to share");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }
}
