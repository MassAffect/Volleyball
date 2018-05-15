package com.example.android.volleyball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int blockTeamA = 0;
    int blockTeamB = 0;
    int serving = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of blocks for Team A.
     */
    public void displayStatTeamA(int block) {
        TextView blockView = findViewById(R.id.team_a_block);
        blockView.setText(String.valueOf(block));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of blocks for Team B.
     */
    public void displayStatTeamB(int block) {
        TextView blockView = findViewById(R.id.team_b_block);
        blockView.setText(String.valueOf(block));
    }

    /**
     * This method is called when the scoreForA button is clicked. Method assumes team A always
     * serves first. Team cannot earn a point until after winning the serve.
     */
    public void scoreForA(View view) {
        if (serving == 0) {
            scoreTeamA = scoreTeamA + 1;
        } else
            scoreTeamA = scoreTeamA + 0;
        String nowServing = "Team A Now Serving";
        displayMessage(nowServing);
        displayForTeamA(scoreTeamA);
        serving = 0;
    }

    /**
     * This method is called when the blockForA button is clicked. This method will increment
     * the number of blocks the team has successfully made
     */
    public void blockForA(View view) {
        blockTeamA = blockTeamA + 1;
        displayStatTeamA(blockTeamA);
    }

    /**
     * This method is called when the scoreForB button is clicked. Team cannot earn a point until
     * after winning the serve.
     */
    public void scoreForB(View view) {

        if (serving == 1) {
            scoreTeamB = scoreTeamB + 1;
        } else
            scoreTeamB = scoreTeamB + 0;
        String nowServing = "Team B Now Serving";
        displayMessage(nowServing);
        displayForTeamB(scoreTeamB);
        serving = 1;
    }

    /**
     * This method is called when the blockForB button is clicked. This method will increment
     * the number of blocks the team has successfully made
     */
    public void blockForB(View view) {
        blockTeamB = blockTeamB + 1;
        displayStatTeamB(blockTeamB);
    }


    /**
     * This method is called when the reset button is clicked.
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        blockTeamA = 0;
        blockTeamB = 0;
        serving = 0;
        String nowServing = " ";
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayStatTeamA(blockTeamA);
        displayStatTeamB(blockTeamB);
        displayMessage(nowServing);

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage (String message) {
        TextView serveMessage = findViewById(R.id.serveMessage);
        serveMessage.setText(message);
    }

}
