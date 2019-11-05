package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.continuous.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class resultActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    @SuppressLint({"ApplySharedPref", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        toolbar = findViewById(R.id.toolTest);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        actionBar = getSupportActionBar();
        actionBar.setTitle("Test");

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        SharedPreferences settings = getSharedPreferences("quizzler", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore +=score;

        resultLabel.setText(score +" / 10");
        totalScoreLabel.setText("Total Score: "+ totalScore);

        //Update total score
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();
    }
}
