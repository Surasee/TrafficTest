package com.tho.traffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    private TextView questionTextView;
    private ImageView TrafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton,
            choice3RadioButton, choice4RadioButton;

    private Button button;

    private String[] questionStrings;
    private int[] imageInts;
    private int radioAnInt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        //เชื่อมกับ xml
        BindWidget();



        //radio Controller
        radioController();



    }//oncreate

    private void radioController() {
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }

            }
        });


    }

    private void BindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        TrafficImageView = (ImageView) findViewById(R.id.imvTraffic);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);

    }

    @Override
    protected void onStart() {
        //setup

        questionStrings = getResources().getStringArray(R.array.question);

        imageInts = new int[10];
        imageInts[0] = R.drawable.traffic_01;
        imageInts[1] = R.drawable.traffic_02;
        imageInts[2] = R.drawable.traffic_03;
        imageInts[3] = R.drawable.traffic_04;
        imageInts[4] = R.drawable.traffic_05;
        imageInts[5] = R.drawable.traffic_06;
        imageInts[6] = R.drawable.traffic_07;
        imageInts[7] = R.drawable.traffic_08;
        imageInts[8] = R.drawable.traffic_09;
        imageInts[9] = R.drawable.traffic_10;

        String[] strChoice = getResources().getStringArray(R.array.times1);

        //Just Start
        questionTextView.setText(questionStrings[0]);
        TrafficImageView.setImageResource(imageInts[0]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);
        super.onStart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}//class
