package com.example.fabiansebban.coursandroid_activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.example.fabiansebban.coursandroid_activities.SubActivity;

public class MainActivity extends AppCompatActivity {

    private Button shareButton;
    private Button otherLayoutButton;
    private Button sharedPrefenrecesButton;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instance of the shared preference
        SharedPreferences sharedPreferences = getSharedPreferences("con", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.SHARED_PREFERENCE_TEST, "testing shared preferences");
        editor.commit();

        shareButton = (Button)findViewById(R.id.shareButton);

        //Send a text to another app when click
        shareButton.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my awwwwwsome text to share !! ");
                sendIntent.setType("text/plain");
                startActivityForResult(sendIntent, Constant.CALL_BACK_RESULT);
            }
        });

        otherLayoutButton = (Button)findViewById(R.id.buttonToLayout);

        otherLayoutButton.setOnClickListener(new  View.OnClickListener() {

            public void onClick(View v) {
                message = "test";

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra(intent.EXTRA_TEXT, message);
                startActivityForResult(intent, Constant.CALL_BACK_RESULT);
            }
        });

        sharedPrefenrecesButton = (Button)findViewById(R.id.sharedPreferencesButton);

        sharedPrefenrecesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set SharedPreferences params
                SharedPreferences sharedPreferences = getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Constant.SHARED_PREFERENCE_TEST, "testing shared preferences");
                editor.commit();

                //Open a new intent
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });
    }
}
