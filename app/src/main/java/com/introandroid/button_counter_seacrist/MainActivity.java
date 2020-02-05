package com.introandroid.button_counter_seacrist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView numberCount;
    Button clearButton;
    Button increaseButton;
    Button decreaseButton;
    int numberCounter;
    String countText;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String value = numberCount.getText().toString();
        savedInstanceState.putString("key",value );
        savedInstanceState.putInt("numKey", numberCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String value = savedInstanceState.getString("key");
        numberCount.setText(value);
        numberCounter = savedInstanceState.getInt("numKey");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberCount = (TextView) findViewById(R.id.clickValue);
        clearButton = (Button) findViewById(R.id.clearButton);
        increaseButton = (Button) findViewById(R.id.increaseButton);
        decreaseButton = (Button) findViewById(R.id.decreaseButton);
        countText = getString(R.string.counterText);


        numberCounter = 0;

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberCounter ++;
                numberCount.setText (countText + numberCounter);
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberCounter --;
                numberCount.setText (countText + numberCounter);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberCounter = 0;
                numberCount.setText (countText + numberCounter);
            }
        });


    }
}
