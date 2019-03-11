package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //          Decrease the score for Team A by 1 point.
        Button btnMinusA = findViewById(R.id.minus_one_a);
        btnMinusA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreTeamA == 0) return;
                scoreTeamA -= 1;
                displayForTeamA(scoreTeamA);
            }
        });

        //          Decrease the score for Team B by 1 point.
        Button btnMinusB = findViewById(R.id.minus_one_b);
        btnMinusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreTeamB == 0) return;
                scoreTeamB -= 1;
                displayForTeamB(scoreTeamB);
            }
        });

        //          Decrease fouls for Team A by 1.
        Button btnMinusFoulA = findViewById(R.id.minus_foul_a);
        btnMinusFoulA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foulsTeamA == 0) return;
                foulsTeamA -= 1;
                displayFoulForTeamA(foulsTeamA);
            }
        });

        //          Decrease fouls for Team B by 1.
        Button btnMinusFoulB = findViewById(R.id.minus_foul_b);
        btnMinusFoulB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foulsTeamB == 0) return;
                foulsTeamB -= 1;
                displayFoulForTeamB(foulsTeamB);
            }
        });
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase foul for Team A by 1.
     */
    public void addFoulForTeamA(View v) {
        foulsTeamA += 1;
        displayFoulForTeamA(foulsTeamA);
    }

    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulForTeamA(foulsTeamA);
        displayFoulForTeamB(foulsTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given fouls for Team A.
     */
    public void displayFoulForTeamA(int foul) {
        TextView foulsView = findViewById(R.id.team_a_fouls);
        foulsView.setText(String.valueOf(foul));
    }

    /**
     * Displays the given fouls for Team B.
     */
    public void displayFoulForTeamB(int fouls) {
        TextView foulsView = findViewById(R.id.team_b_fouls);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase fouls for Team B by 1.
     */
    public void addFoulForTeamB(View v) {
        foulsTeamB += 1;
        displayFoulForTeamB(foulsTeamB);
    }
}
