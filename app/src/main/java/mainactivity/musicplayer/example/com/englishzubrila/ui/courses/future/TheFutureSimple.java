package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.future;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class TheFutureSimple extends AppCompatActivity {

    private ImageView bPley1;
    private SeekBar seekBar1;
    private MediaPlayer player1;
    private Runnable runnable1;
    private Handler handler1;

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_future_simple);

        toolbar = findViewById(R.id.toolThe);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("The Future Simple");

        getLessonA();
    }
    private void getLessonA() {
        bPley1 = findViewById(R.id.tPlayer0);

        handler1 = new Handler();

        seekBar1 = findViewById(R.id.seekBar0);

        player1 = MediaPlayer.create(this, R.raw.lesson22_7);

        player1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar1.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarA();
                player1.pause();
            }
        });
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player1.seekTo(i);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    private void changeSeekBarA() {
        seekBar1.setProgress(player1.getCurrentPosition());

        if (player1.isPlaying()) {
            runnable1 = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarA();
                }
            };
            handler1.postDelayed(runnable1, 1000);
        }
        bPley1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tPlayer0:
                        if (player1.isPlaying()) {
                            player1.pause();
                            bPley1.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player1.start();
                            changeSeekBarA();
                            bPley1.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler1.removeCallbacks(null);
        player1.stop();
    }
}
