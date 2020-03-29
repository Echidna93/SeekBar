package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // create instance of SeekBar
    private SeekBar seekBar;
    // create instance of TextView
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //grab instance of textView displays the result textview
        resultTextView = (TextView) findViewById(R.id.resultID);
        // grab instance of seekBar class by ID seekBarID
        seekBar = (SeekBar) findViewById(R.id.seekBarID);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultTextView.setTextColor(Color.BLACK);
                resultTextView.setText("Pain Level: " + seekBar.getProgress() + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SB", "StartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() >= 70){
                    resultTextView.setTextColor(Color.RED);
                }
            }
        });
    }
}
