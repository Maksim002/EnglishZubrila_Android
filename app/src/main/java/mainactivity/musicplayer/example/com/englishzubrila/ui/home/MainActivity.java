package mainactivity.musicplayer.example.com.englishzubrila.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.InitialFragment;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class MainActivity extends AppCompatActivity {
    private TextView textE,textN, textG, textL, textI,textS, textH;

    private static int SPLAH_TAME_OUT = 860;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textE = findViewById(R.id.textE);
        textN = findViewById(R.id.textN);
        textG = findViewById(R.id.textG);
        textL = findViewById(R.id.textL);
        textI = findViewById(R.id.textI);
        textS = findViewById(R.id.textS);
        textH = findViewById(R.id.textH);

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
        Animation animationE = AnimationUtils.loadAnimation(this, R.anim.anim_e);
        textE.startAnimation(animationE);
        Animation animationN = AnimationUtils.loadAnimation(this, R.anim.anim_n);
        textN.startAnimation(animationN);
        Animation animationG = AnimationUtils.loadAnimation(this, R.anim.anim_g);
        textG.startAnimation(animationG);
        Animation animationL = AnimationUtils.loadAnimation(this, R.anim.anim_l);
        textL.startAnimation(animationL);
        Animation animationI = AnimationUtils.loadAnimation(this, R.anim.anim_i);
        textI.startAnimation(animationI);
        Animation animationS = AnimationUtils.loadAnimation(this, R.anim.anim_s);
        textS.startAnimation(animationS);
        Animation animationH = AnimationUtils.loadAnimation(this, R.anim.anim_h);
        textH.startAnimation(animationH);
    }
}