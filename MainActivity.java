package com.example.my1app.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.my1app.R;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingTextView;
    private EditText mNameEditText;
    private Button mPlayButton;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private static final String SHARED_PREF_USER_INFO = "SHARED_PREF_USER_INFO";
    private static final String SHARED_PREF_USER_INFO_NAME = "SHARED_PREF_USER_INFO_NAME";
    private int Score;
    private String Name;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            Score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingTextView = findViewById(R.id.main_textview_greeting);
        mNameEditText = findViewById(R.id.main_edittext_name);
        mPlayButton = findViewById(R.id.main_button_play);

        //Turn off the button
        mPlayButton.setEnabled(false);

        Name = getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE).getString(SHARED_PREF_USER_INFO_NAME, null);

        if (Name != null){
            mGreetingTextView.setText("Hey "+ Name + " goo to see you again!");
        }

        //Wait for input username
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int end) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int end) {}

            @Override
            public void afterTextChanged(Editable s) {
                mPlayButton.setEnabled(!s.toString().isEmpty());
            }
        });

        //Action after pressing start button
        mPlayButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
           getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE)
                   .edit()
                   .putString(SHARED_PREF_USER_INFO_NAME, mNameEditText.getText().toString())
                   .apply();

            Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
            startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
           }
       });

    }
}