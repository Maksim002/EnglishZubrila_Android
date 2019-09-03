package mainactivity.musicplayer.example.com.englishzubrila.Glav;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.InitialFragment;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class MainActivity extends AppCompatActivity {
    private ImageView imageZp,imageS;
    private TextView tvView,start,start1;

    private static int SPLAH_TAME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageZp = findViewById(R.id.imageG);
        imageS = findViewById(R.id.imageS);
        tvView = findViewById(R.id.tView);
        start = findViewById(R.id.start);
        start1 = findViewById(R.id.start1);

        setImageScroll();
        setTextZp();
    }
    private void setImageScroll(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, InitialFragment.class);
                startActivity(intent);
                finish();
            }
        },SPLAH_TAME_OUT);
    }
    private void setTextZp(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up);
        imageZp.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        animation1.setStartOffset(1000);
        tvView.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up);
        imageS.startAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up);
        start.startAnimation(animation3);

        Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up);
        start1.startAnimation(animation4);
    }
}