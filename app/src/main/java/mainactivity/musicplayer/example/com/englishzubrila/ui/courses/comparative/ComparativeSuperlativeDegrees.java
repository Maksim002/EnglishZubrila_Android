package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.comparative;

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

public class ComparativeSuperlativeDegrees extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPleyE;
    private SeekBar seekBarB;
    private MediaPlayer playerS;
    private Runnable runnableD;
    private Handler handlerF;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparative_superlative_degrees);

        toolbar = findViewById(R.id.toolComparative);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Comparative and Superlative Degrees");

        getLessonA();
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
        bPleyE = findViewById(R.id.cPlayerE);

        handlerF = new Handler();

        seekBarB = findViewById(R.id.seekBarFi);

        playerS = MediaPlayer.create(this, R.raw.lesson23_3);

        playerS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarB.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarA();
                playerS.pause();
            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
    private void changeSeekBarA() {
        seekBarB.setProgress(playerS.getCurrentPosition());

        if (playerS.isPlaying()) {
            runnableD = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarA();
                }
            };
            handlerF.postDelayed(runnableD, 1000);
        }
        bPleyE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.cPlayerE:
                        if (playerS.isPlaying()) {
                            playerS.pause();
                            bPleyE.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerS.start();
                            changeSeekBarA();
                            bPleyE.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handlerF.removeCallbacks(null);
        playerS.stop();
    }
}
