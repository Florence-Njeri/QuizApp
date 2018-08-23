package com.example.admin.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final int[] totalScore = {extras.getInt("testScoreVariable")};
            TextView scoreView = findViewById(R.id.score_text_view);
            if (totalScore[0] < 50) {
                scoreView.setText("Try Again \n" + totalScore[0]);
            } else {
                scoreView.setText("Excellent, your score is: \n" + totalScore[0]);
            }

            Button reset = findViewById(R.id.reset);
            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    totalScore[0] = 0;
                    Intent resetIntent = new Intent(ScoreDisplayActivity.this, MainActivity.class);
                    startActivity(resetIntent);
                }
            });

        }

    }
}
