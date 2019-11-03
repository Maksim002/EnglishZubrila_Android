package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.teherels;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class ThereIS extends AppCompatActivity {

    private ImageView bPley;
    private SeekBar seekBar;
    private MediaPlayer player;
    private Runnable runnable;
    private Handler handler;

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_there_is);


        toolbar = findViewById(R.id.toolbarAlphabet3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setTitle("There Is");

        gropeBottom();
        setPlayer();

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
            bPley = findViewById(R.id.bPlaye);

            handler = new Handler();

            seekBar = findViewById(R.id.seekBarr);
        }

        private void setPlayer() {
            player = MediaPlayer.create(this, R.raw.lesson10_4);

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
                        case R.id.bPlaye:
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacks(null);
        player.stop();
    }
}
