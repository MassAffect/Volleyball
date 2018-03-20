package com.example.android.volleyball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.volleyball.R;


public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
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
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
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
     * This method is called when the reset button is clicked.
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        serving = 0;
        String nowServing = " ";
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayMessage(nowServing);

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage (String message) {
        TextView serveMessage = (TextView) findViewById(R.id.serveMessage);
        serveMessage.setText(message);
    }

}
