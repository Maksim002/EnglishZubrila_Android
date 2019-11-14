package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.haveto;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class HaveTo extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPleyE, bPleyB;
    private SeekBar seekBarE, seekBarB;
    private MediaPlayer playerE, playerB;
    private Runnable runnableE, runnableB;
    private Handler handlerE, handlerB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_to);

        toolbar = findViewById(R.id.toolHaveTo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Have To");

        getLessonA();
        getLessonE();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getLessonA() {
        bPleyE = findViewById(R.id.bPlayer);

        handlerE = new Handler();

        seekBarE = findViewById(R.id.s);

        playerE = MediaPlayer.create(this, R.raw.lesson17_4);

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
                    case R.id.bPlayer:
                        if (playerE.isPlaying()) {
                            playerE.pause();
                            bPleyE.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerE.start();
                            changeSeekBarA();
                            bPleyE.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonE() {
        bPleyB = findViewById(R.id.bPlayFi);

        handlerB = new Handler();

        seekBarB = findViewById(R.id.sI);

        playerB = MediaPlayer.create(this, R.raw.lesson18_3);

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
        bPleyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayFi:
                        if (playerB.isPlaying()) {
                            playerB.pause();
                            bPleyB.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerB.start();
                            changeSeekBarE();
                            bPleyB.setImageResource(R.drawable.ic_pause_black_24dp);
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
