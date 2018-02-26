package com.example.flavin.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar setTime;
    TextView timer;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.time);
        setTime = (SeekBar) findViewById(R.id.slider);

        setTime.setMax(10);
        setTime.setProgress(5);

        slideshowLength();

        btn = (Button) findViewById(R.id.runBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Page2.class);
                String passing = timer.getText().toString();
                Bundle b = new Bundle();
                b.putString("howlong", passing);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    public void slideshowLength() {
        setTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int whatTime;
                String temp;

                whatTime = setTime.getProgress();
                temp = String.valueOf(whatTime);
                timer.setText(temp);
            }
        });
    }

}