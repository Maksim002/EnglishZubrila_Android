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
    private MediaPlayer playerE, playerB, playerS;
    private Runnable runnablE, runnableB, runnableS;
    private Handler handlerE, handlerB, handlerS;

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
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void gropeBottom() {
        bPleyE = findViewById(R.id.bP);
        bPleyB = findViewById(R.id.b);
        bPleyS = findViewById(R.id.bPlayF);

        handlerE = new Handler();
        handlerB = new Handler();
        handlerS = new Handler();

        seekBaE = findViewById(R.id.seekBarP);
        seekBarB = findViewById(R.id.seekBarE);
        seekBarS = findViewById(R.id.seekBarE);
    }

    private void setPlayerE() {
        playerE = MediaPlayer.create(this, R.raw.lesson5_1);

        playerE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBaE.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
                playerE.pause();
            }
        });

        seekBaE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

    private void changeSeekbar() {
        seekBaE.setProgress(playerE.getCurrentPosition());

        if (playerE.isPlaying()) {
            runnablE = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handlerE.postDelayed(runnablE, 1000);
        }

        bPleyE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bP:
                        if (playerE.isPlaying()) {
                            playerE.pause();
                            bPleyE.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerE.start();
                            changeSeekbar();
                            bPleyE.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void setPlayerB() {
        playerB = MediaPlayer.create(this, R.raw.lesson5_2);

        playerB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarB.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbarE();
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

    private void changeSeekbarE() {
        seekBarB.setProgress(playerB.getCurrentPosition());

        if (playerB.isPlaying()) {
            runnableB = new Runnable() {
                @Override
                public void run() {
                    changeSeekbarE();
                }
            };
            handlerB.postDelayed(runnableB, 1000);
        }

        bPleyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.b:
                        if (playerB.isPlaying()) {
                            playerB.pause();
                            bPleyB.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerB.start();
                            changeSeekbarE();
                            bPleyB.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void setPlayerS() {
        playerS = MediaPlayer.create(this, R.raw.lesson5_3);

        playerS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarS.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbarB();
                playerS.pause();
            }
        });

        seekBarS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerS.seekTo(i);
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
        seekBarS.setProgress(playerS.getCurrentPosition());

        if (playerS.isPlaying()) {
            runnableS = new Runnable() {
                @Override
                public void run() {
                    changeSeekbarB();
                }
            };
            handlerS.postDelayed(runnableS, 1000);
        }

        bPleyS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayF:
                        if (playerS.isPlaying()) {
                            playerS.pause();
                            bPleyS.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerS.start();
                            changeSeekbarB();
                            bPleyS.setImageResource(R.drawable.ic_stop_black_24dp);
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
        handlerS.removeCallbacks(null);
        playerS.stop();
    }
}
