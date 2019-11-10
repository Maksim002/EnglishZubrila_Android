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

    private ImageView bPleyE;
    private SeekBar seekBarE;
    private MediaPlayer playerE;
    private Runnable runnableE;
    private Handler handlerE;

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
        bPleyE = findViewById(R.id.tPlayerE);

        handlerE = new Handler();

        seekBarE = findViewById(R.id.seekBarE);

        playerE = MediaPlayer.create(this, R.raw.lesson22_7);

        playerE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarE.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarA();
                playerE.pause();
            }
        });
        seekBarE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerE.seekTo(i);
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
        seekBarE.setProgress(playerE.getCurrentPosition());

        if (playerE.isPlaying()) {
            runnableE = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarA();
                }
            };
            handlerE.postDelayed(runnableE, 1000);
        }
        bPleyE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tPlayerE:
                        if (playerE.isPlaying()) {
                            playerE.pause();
                            bPleyE.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerE.start();
                            changeSeekBarA();
                            bPleyE.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handlerE.removeCallbacks(null);
        playerE.stop();
    }
}
