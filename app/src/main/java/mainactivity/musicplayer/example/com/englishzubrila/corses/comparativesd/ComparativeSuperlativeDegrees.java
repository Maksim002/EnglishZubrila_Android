package mainactivity.musicplayer.example.com.englishzubrila.corses.comparativesd;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class ComparativeSuperlativeDegrees extends AppCompatActivity {

    private ImageView bPley1;
    private SeekBar seekBar1;
    private MediaPlayer player1;
    private Runnable runnable1;
    private Handler handler1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparative_superlative_degrees);

        getLessonA();
    }
    private void getLessonA() {
        bPley1 = findViewById(R.id.cPlayer0);

        handler1 = new Handler();

        seekBar1 = findViewById(R.id.seekBar0);

        player1 = MediaPlayer.create(this, R.raw.lesson23_3);

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
                    case R.id.cPlayer0:
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
}
