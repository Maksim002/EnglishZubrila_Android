package mainactivity.musicplayer.example.com.englishzubrila.Glav;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startText = findViewById(R.id.startText);
        startText.setOnClickListener(listener);

        fade();
    }

    public void fade(){
        animation = AnimationUtils.loadAnimation(this,R.anim.fadeout);
        startText.startAnimation(animation);
    }



    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.startText:
                    Intent intent = new Intent(MainActivity.this, InitialFragment.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}