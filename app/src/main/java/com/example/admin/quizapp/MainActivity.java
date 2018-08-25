package com.example.admin.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int testScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Question One
    public void questionOne() {
        EditText androidVersion = findViewById(R.id.android_version_edit_text);
        String answerOne = androidVersion.getText().toString();
        if (answerOne.trim().equalsIgnoreCase("pie")) {
            testScore += 20;

        }
        //Setting the error message if the field is left blank
        else if (answerOne.isEmpty()) {
            androidVersion.setError("Cant be empty");
        }

    }

    //Question Two
    public void questionTwo() {
        CheckBox alarm = findViewById(R.id.alarm_intent);
        CheckBox games = findViewById(R.id.games_intent);
        CheckBox contacts = findViewById(R.id.contacts_intents);
        CheckBox email = findViewById(R.id.emails_intent);
        if (alarm.isChecked() && contacts.isChecked() && email.isChecked() && !games.isChecked()) {
            testScore += 20;

        } else if (games.isChecked()) {

            //If checkbox checked, set checkbox and background text color red
            games.setBackgroundColor(Color.parseColor("#ff0000"));

            testScore += 0;
        } else {
            testScore += 0;
        }

    }

    //Question Three
    public void questionThree() {
        RadioButton notNecessarily = findViewById(R.id.not_necessarily);
        RadioButton yes = findViewById(R.id.yes);
        if (notNecessarily.isChecked()) {
            testScore += 20;
        }
        if (yes.isChecked()) {
            testScore += 0;
            //If checkbox checked, set checkbox and background text color red
            yes.setBackgroundColor(Color.parseColor("#ff0000"));
            yes.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    //Question Four
    public void questionFour() {

        CheckBox alert = findViewById(R.id.alert_dialog);
        CheckBox progress = findViewById(R.id.progress_dialog);
        CheckBox timePicker = findViewById(R.id.time_picker_dialog);
        CheckBox prompt = findViewById(R.id.prompt_dialog);

        if (alert.isChecked() && progress.isChecked() && timePicker.isChecked() && !prompt.isChecked()) {
            testScore += 20;

        } else if (prompt.isChecked()) {
            testScore += 0;
            //If checkbox checked, set checkbox and background text color red
            prompt.setBackgroundColor(Color.parseColor("#ff0000"));
            prompt.setTextColor(Color.parseColor("#ff0000"));
        } else {
            testScore += 0;
        }
    }

    //Question Five
    public void questionFive() {

        RadioButton sqlDatabase = findViewById(R.id.sql_database);
        RadioButton localChache = findViewById(R.id.local_cache);
        RadioButton sharedPreference = findViewById(R.id.shared_preference);
        RadioButton sqlLiteStorage = findViewById(R.id.sqlite_storage);
        if (sqlDatabase.isChecked()) {
            testScore += 20;

        }
        if (localChache.isChecked()) {
            localChache.setBackgroundColor(Color.parseColor("#ff0000"));
            localChache.setTextColor(Color.parseColor("#ff0000"));
            testScore += 0;
            {
                if (sharedPreference.isChecked()) {

                    sharedPreference.setBackgroundColor(Color.parseColor("#ff0000"));
                    sharedPreference.setTextColor(Color.parseColor("#ff0000"));
                    testScore += 0;
                }
                if (sqlLiteStorage.isChecked()) {

                    //If RadioButton checked, set RadioButton and background text color red

                    sqlLiteStorage.setBackgroundColor(Color.parseColor("#ff0000"));
                    sqlLiteStorage.setTextColor(Color.parseColor("#ff0000"));
                    testScore += 0;
                }

            }
        }
    }

    public void submit(View view) {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
        Toast.makeText(this, "Your score is: " + testScore, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ScoreDisplayActivity.class);
        intent.putExtra("testScoreVariable", testScore);
        startActivity(intent);
        testScore = 0;
    }


}
