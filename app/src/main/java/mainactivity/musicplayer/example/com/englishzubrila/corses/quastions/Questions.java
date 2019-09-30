package mainactivity.musicplayer.example.com.englishzubrila.corses.quastions;

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

    private ImageView bPley,bPley2,bPley3;
    private SeekBar seekBar,seekBar2,seekBar3;
    private MediaPlayer player,player2,player3;
    private Runnable runnable,runnable2,runnable3;
    private Handler handler,handler2,handler3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        toolbar = findViewById(R.id.toolbarAlphabet4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gropeBottom();

        setPlayer();
        setPlayer2();
        setPlayer3();

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
        bPley = findViewById(R.id.bPlay1);
        bPley2 = findViewById(R.id.bPlay2);
        bPley3 = findViewById(R.id.bPlay3);

        handler = new Handler();
        handler2 = new Handler();
        handler3 = new Handler();

        seekBar = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
    }

    private void setPlayer() {
        player = MediaPlayer.create(this, R.raw.lesson5_1);

        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
                player.pause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player.seekTo(i);
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
        seekBar.setProgress(player.getCurrentPosition());

        if (player.isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }

        bPley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay1:
                        if (player.isPlaying()) {
                            player.pause();
                            bPley.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player.start();
                            changeSeekbar();
                            bPley.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void setPlayer2() {
        player2 = MediaPlayer.create(this, R.raw.lesson5_2);

        player2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar2.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar2();
                player2.pause();
            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player2.seekTo(i);
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

    private void changeSeekbar2() {
        seekBar2.setProgress(player2.getCurrentPosition());

        if (player2.isPlaying()) {
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar2();
                }
            };
            handler2.postDelayed(runnable2, 1000);
        }

        bPley2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay2:
                        if (player2.isPlaying()) {
                            player2.pause();
                            bPley2.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player2.start();
                            changeSeekbar2();
                            bPley2.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void setPlayer3() {
        player3 = MediaPlayer.create(this, R.raw.lesson5_3);

        player3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar3.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar3();
                player3.pause();
            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player3.seekTo(i);
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

    private void changeSeekbar3() {
        seekBar3.setProgress(player3.getCurrentPosition());

        if (player3.isPlaying()) {
            runnable3 = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar3();
                }
            };
            handler3.postDelayed(runnable3, 1000);
        }

        bPley3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay3:
                        if (player3.isPlaying()) {
                            player3.pause();
                            bPley3.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player3.start();
                            changeSeekbar3();
                            bPley3.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
        player2.stop();
        player3.stop();
    }
}
