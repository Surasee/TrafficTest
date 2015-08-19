package com.tho.traffic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    private TextView questionTextView;
    private ImageView TrafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton,
            choice3RadioButton, choice4RadioButton;


    private String[] questionStrings;
    private int[] imageInts, intTime;
    private int radioAnInt,indexAnInt, scoreAnInt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        //เชื่อมกับ xml
        BindWidget();


        //radio Controller
        radioController();


    }//oncreate

    public void clickAnswer(View view) {

        if (radioAnInt == 0) {
            Toast.makeText(TestActivity.this, "กรุณาตอบคำถาม", Toast.LENGTH_SHORT).show();
        } else {
            checkScore();
            myModel();

        }

    }//clickAnswer

    private void myModel() {

        if (indexAnInt == 9) {

            showAnswerDialog();

        } else {

            //checkScore

            //checkScore();

            indexAnInt += 1;




            //changView
            changeView(indexAnInt);





        }


    }//mymodel

    private void checkScore() {

        int[] intTrueAnswer = {1,2,3,4,1,2,3,4,1,2};
        if(radioAnInt == intTrueAnswer[indexAnInt] ){

            scoreAnInt+=1;

        }


    }//cheackScore

    private void changeView(int AnInt) {

        // chengequestion
        questionTextView.setText(questionStrings[AnInt]);
        // changeImage
        TrafficImageView.setImageResource(imageInts[AnInt]);

        //Choice
        choiceRadioGroup.clearCheck();
        String[] strChoice = getResources().getStringArray(intTime[AnInt]);

        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);





    }//changeView

    private void showAnswerDialog() {

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.icon_myaccount);
        objBuilder.setTitle("Show Score");
        objBuilder.setMessage("Total score " + Integer.toString(scoreAnInt) + " .");
        objBuilder.setCancelable(false);//ห้าม undo
        objBuilder.setNegativeButton("Play Now!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onStart();
                choiceRadioGroup.clearCheck();
                dialogInterface.dismiss();
            }
        });
        objBuilder.setPositiveButton("Read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent objIntent = new Intent(TestActivity.this, MainActivity.class);
                startActivity(objIntent);
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();
    }//showAnswerDialog

    private void radioController() {
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
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

        scoreAnInt = 0;
        indexAnInt = 0;

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


        intTime = new int[10];
        intTime[0] = R.array.times1;
        intTime[1] = R.array.times2;
        intTime[2] = R.array.times3;
        intTime[3] = R.array.times4;
        intTime[4] = R.array.times5;
        intTime[5] = R.array.times6;
        intTime[6] = R.array.times7;
        intTime[7] = R.array.times8;
        intTime[8] = R.array.times9;
        intTime[9] = R.array.times10;









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
