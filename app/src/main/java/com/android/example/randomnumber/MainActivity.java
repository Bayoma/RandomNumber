package com.android.example.randomnumber;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ColorWheel mColorWheel = new ColorWheel();

    private TextView mRandomText;
    private Button mRandomButton;
    private RelativeLayout mRelativeLayout;
    private Button mButton;
    private TextView mTextview3;
    private Button cButton;
    String fact, s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRandomText = (TextView) findViewById(R.id.textView2);
        mRandomButton = (Button) findViewById(R.id.Randombutton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        mButton = (Button) findViewById(R.id.button2);
        mTextview3 = (TextView) findViewById(R.id.textView3);
        cButton = (Button) findViewById(R.id.clearbutton);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = mColorWheel.getColor();
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(10) + 1;
                fact = randomNumber + "";

                mRandomText.setText(fact);
                mRelativeLayout.setBackgroundColor(color);
                mRandomButton.setTextColor(color);
                s = s + " " + fact + "";

                ArrayList<Integer> RepeatItems = new ArrayList<Integer>();


               // mTextview3.setText(RepeatItems.get(0));

//                if(randomNumber==(RepeatItems.get(0))){
//
//                    mTextview3.setText("IT's Matching");
//                }
               // RepeatItems.add(randomNumber);
            }
        };

        mRandomButton.setOnClickListener(listener);
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s != "") {
                    mTextview3.setText(s);

                } else {
                    Toast.makeText(MainActivity.this, "No Random Items", Toast.LENGTH_LONG).show();
                }
            }

        };

            mButton.setOnClickListener(ocl);


            View.OnClickListener clearListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete

                                if (s != "") {
                                    s = "";
                                    mTextview3.setText(s);
                                    Toast.makeText(MainActivity.this, "Numbers are Cleared", Toast.LENGTH_LONG).show();
                                } else {

                                    Toast.makeText(MainActivity.this, "No items to Clear", Toast.LENGTH_LONG).show();

                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();



                }
            };
            cButton.setOnClickListener(clearListener);



        }
    }