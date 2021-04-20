package com.example.week9fm5cc5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.week9fm5cc5.helpers.GenerateAscii;
import com.example.week9fm5cc5.helpers.ReplaceCharacters;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonGenerateAscii = (Button) findViewById(R.id.generateAscii);
        final Button buttonReplaceCharacters = (Button) findViewById(R.id.replaceCharacters);
        final EditText inputBox = (EditText) findViewById(R.id.inputBox);
        final TextView resultText = (TextView) findViewById(R.id.resultText);

        /*
         |-------------------------------
         | Calculate sum of Ascii
         |-------------------------------
        */
        buttonGenerateAscii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenerateAscii generateAscii = new GenerateAscii();
                String result = String.valueOf((int) generateAscii.sum(inputBox.getText().toString()));
                resultText.setText("Sum of ASCII = " + result);
            }
        });

        /*
         |-------------------------------
         | Replace Characters
         |-------------------------------
        */
        buttonReplaceCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceCharacters replaceCharacters = new ReplaceCharacters();
                String result = replaceCharacters.generate(inputBox.getText().toString());
                resultText.setText("Result = \"" + result + "\"");
            }
        });
    }
}