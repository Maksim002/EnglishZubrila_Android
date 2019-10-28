package mainactivity.musicplayer.example.com.englishzubrila.corses.haveto;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class HaveTo extends AppCompatActivity {

    private ImageView bPley1,bPley2;
    private SeekBar seekBar1, seekBar2;
    private MediaPlayer player1, player2;
    private Runnable runnable1, runnable2;
    private Handler handler1, handler2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_to);

        getLessonA();
        getLessonE();
    }
    private void getLessonA() {
        bPley1 = findViewById(R.id.bPlay);

        handler1 = new Handler();

        seekBar1 = findViewById(R.id.s);

        player1 = MediaPlayer.create(this, R.raw.lesson17_4);

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
                    case R.id.bPlay:
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

    private void getLessonE() {
        bPley2 = findViewById(R.id.bPlay1);

        handler2 = new Handler();

        seekBar2 = findViewById(R.id.s1);

        player2 = MediaPlayer.create(this, R.raw.lesson18_3);

        player2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar2.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarE();
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
    private void changeSeekBarE() {
        seekBar2.setProgress(player2.getCurrentPosition());

        if (player2.isPlaying()) {
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarE();
                }
            };
            handler2.postDelayed(runnable2, 1000);
        }
        bPley2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay1:
                        if (player2.isPlaying()) {
                            player2.pause();
                            bPley2.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player2.start();
                            changeSeekBarE();
                            bPley2.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }
}
