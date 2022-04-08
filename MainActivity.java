package com.tanisk.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Button b1;
    String s1, s2;
    EditText e1, e2;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.password);
        b1 = findViewById(R.id.LoginBtn);
        ts = new TextToSpeech(MainActivity.this, this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if(s1.contentEquals("Abhishek") && s2.contentEquals("12345")) {
                    ts.speak("Successfully logged in", TextToSpeech.QUEUE_ADD, null);
                } else {
                    ts.speak("Invalid username or password", TextToSpeech.QUEUE_ADD, null);
                }
            }
        });

    }


    @Override
    public void onInit(int i) {
        ts.setLanguage(Locale.ENGLISH);
        ts.setSpeechRate(0.8f);
    }
}