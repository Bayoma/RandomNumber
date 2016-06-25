package com.android.example.randomnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ColorWheel mColorWheel = new ColorWheel();

    private TextView mRandomText;
    private Button mRandomButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRandomText = (TextView) findViewById(R.id.textView2);
        mRandomButton = (Button) findViewById(R.id.Randombutton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fact;
                int color = mColorWheel.getColor();
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(90);
                fact = randomNumber + "";

                mRandomText.setText(fact);
                mRelativeLayout.setBackgroundColor(color);
                mRandomButton.setTextColor(color);

            }
        };

        mRandomButton.setOnClickListener(listener);
    }
}
