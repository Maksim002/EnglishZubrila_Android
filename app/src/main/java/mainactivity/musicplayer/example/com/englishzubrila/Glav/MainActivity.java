package mainactivity.musicplayer.example.com.englishzubrila.Glav;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.InitialFragment;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class MainActivity extends AppCompatActivity {

    private Animation animation;

    TextView startText;

    private static int SPLAH_TAME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, InitialFragment.class);
                startActivity(intent);
                finish();
            }
        },SPLAH_TAME_OUT);

        startText = findViewById(R.id.startText);

        fade();
    }

    public void fade(){
        animation = AnimationUtils.loadAnimation(this,R.anim.fadeout);
        startText.startAnimation(animation);
    }
}