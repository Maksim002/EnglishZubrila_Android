package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.quastions;

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

public class Questions extends AppCompatActivity {
    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPleyE, bPleyB, bPleyS;
    private SeekBar seekBaE, seekBarB, seekBarS;
    private MediaPlayer playerEt, playerBt, playerSt;
    private Runnable runnablEt, runnableBt, runnableSt;
    private Handler handlerEt, handlerBt, handlerSt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        toolbar = findViewById(R.id.toolbarAlphabetE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gropeBottom();

        setPlayerE();
        setPlayerB();
        setPlayerS();

        actionBar = getSupportActionBar();
        actionBar.setTitle("Questions");
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private void gropeBottom() {
        bPleyE = findViewById(R.id.bP);
        bPleyB = findViewById(R.id.b);
        bPleyS = findViewById(R.id.bPlayFi);

        handlerEt = new Handler();
        handlerBt = new Handler();
        handlerSt = new Handler();

        seekBaE = findViewById(R.id.seekBarP);
        seekBarB = findViewById(R.id.seekBarFi);
        seekBarS = findViewById(R.id.seekBarS);
    }

    private void setPlayerE() {
        playerEt = MediaPlayer.create(this, R.raw.lesson5_1);

        playerEt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBaE.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
                playerEt.pause();
            }
        });

        seekBaE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerEt.seekTo(i);
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

    private void changeSeekbar() {
        seekBaE.setProgress(playerEt.getCurrentPosition());

        if (playerEt.isPlaying()) {
            runnablEt = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handlerEt.postDelayed(runnablEt, 1000);
        }

        bPleyE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bP:
                        if (playerEt.isPlaying()) {
                            playerEt.pause();
                            bPleyE.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerEt.start();
                            changeSeekbar();
                            bPleyE.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void setPlayerB() {
        playerBt = MediaPlayer.create(this, R.raw.lesson5_2);

        playerBt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarB.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbarE();
                playerBt.pause();
            }
        });

        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerBt.seekTo(i);
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

    private void changeSeekbarE() {
        seekBarB.setProgress(playerBt.getCurrentPosition());

        if (playerBt.isPlaying()) {
            runnableBt = new Runnable() {
                @Override
                public void run() {
                    changeSeekbarE();
                }
            };
            handlerBt.postDelayed(runnableBt, 1000);
        }

        bPleyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.b:
                        if (playerBt.isPlaying()) {
                            playerBt.pause();
                            bPleyB.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBt.start();
                            changeSeekbarE();
                            bPleyB.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void setPlayerS() {
        playerSt = MediaPlayer.create(this, R.raw.lesson5_3);

        playerSt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarS.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbarB();
                playerSt.pause();
            }
        });

        seekBarS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerSt.seekTo(i);
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

    private void changeSeekbarB() {
        seekBarS.setProgress(playerSt.getCurrentPosition());

        if (playerSt.isPlaying()) {
            runnableSt = new Runnable() {
                @Override
                public void run() {
                    changeSeekbarB();
                }
            };
            handlerSt.postDelayed(runnableSt, 1000);
        }

        bPleyS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayFi:
                        if (playerSt.isPlaying()) {
                            playerSt.pause();
                            bPleyS.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerSt.start();
                            changeSeekbarB();
                            bPleyS.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handlerEt.removeCallbacks(null);
        playerEt.stop();
        handlerBt.removeCallbacks(null);
        playerBt.stop();
        handlerSt.removeCallbacks(null);
        playerSt.stop();
    }
}
