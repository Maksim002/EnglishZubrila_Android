package mainactivity.musicplayer.example.com.englishzubrila.Glav;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
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
    private ImageView imageScroll,imageZp;

    private static int SPLAH_TAME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageScroll = findViewById(R.id.scroll);
        imageZp = findViewById(R.id.imageG);

        setImageScroll();
        setTextZp();

        animateImageView(imageScroll);
    }

    private void animateImageView(ImageView imageView) {
        final Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = ((Animatable) drawable);
            animatable.start();
        }
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
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        imageZp.startAnimation(animation);
    }
}