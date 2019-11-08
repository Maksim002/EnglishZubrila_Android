package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.can;

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

public class Can extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPlayerE, bPlayerB;
    private SeekBar seekBarE, seekBarB;
    private MediaPlayer playerE, playerB;
    private Runnable runnableE, runnableB;
    private Handler handlerE, handlerB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can);

        toolbar = findViewById(R.id.toolCan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Can");

        getLessonA();
        getLessonE();
    }
    private void getLessonA() {
        bPlayerE = findViewById(R.id.cPlayerE);

        handlerE = new Handler();

        seekBarE = findViewById(R.id.seekBarS);

        playerE = MediaPlayer.create(this, R.raw.lesson13_5);

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
        bPlayerE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.cPlayerE:
                        if (playerE.isPlaying()) {
                            playerE.pause();
                            bPlayerE.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerE.start();
                            changeSeekBarA();
                            bPlayerE.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonE() {
        bPlayerB = findViewById(R.id.cPlayerS);

        handlerB = new Handler();

        seekBarB = findViewById(R.id.seekBarS);

        playerB = MediaPlayer.create(this, R.raw.lesson13_6);

        playerB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarB.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarE();
                playerB.pause();
            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerB.seekTo(i);
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
    private void changeSeekBarE() {
        seekBarB.setProgress(playerB.getCurrentPosition());

        if (playerB.isPlaying()) {
            runnableB = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarE();
                }
            };
            handlerB.postDelayed(runnableB, 1000);
        }
        bPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.cPlayerS:
                        if (playerB.isPlaying()) {
                            playerB.pause();
                            bPlayerB.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerB.start();
                            changeSeekBarE();
                            bPlayerB.setImageResource(R.drawable.ic_stop_black_24dp);
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
        handlerB.removeCallbacks(null);
        playerB.stop();
    }
}
