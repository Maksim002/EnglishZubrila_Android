package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class FirstLevel extends AppCompatActivity {
    private RecyclerView recyclerView;

    private ImageView bPley;
    private SeekBar seekBar;
    private MediaPlayer player;
    private Runnable runnable;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_level);
        gropeBottom();
        setPlayer();


        recyclerView = findViewById(R.id.recyclerViewFragment);
        recyclerView.setAdapter(new FirstAdaptor(this, getTemp()));
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);

    }
    List<Temp> getTemp() {
        List<Temp> temps = new ArrayList<>();
        temps.add(new Temp(R.drawable.a));
        temps.add(new Temp(R.drawable.b));
        temps.add(new Temp(R.drawable.c));
        temps.add(new Temp(R.drawable.d));
        temps.add(new Temp(R.drawable.e));
        temps.add(new Temp(R.drawable.f));
        temps.add(new Temp(R.drawable.g));
        temps.add(new Temp(R.drawable.h));
        temps.add(new Temp(R.drawable.i));
        temps.add(new Temp(R.drawable.j));
        temps.add(new Temp(R.drawable.k));
        temps.add(new Temp(R.drawable.l));
        temps.add(new Temp(R.drawable.m));
        temps.add(new Temp(R.drawable.n));
        temps.add(new Temp(R.drawable.o));
        temps.add(new Temp(R.drawable.p));
        temps.add(new Temp(R.drawable.q));
        temps.add(new Temp(R.drawable.r));
        temps.add(new Temp(R.drawable.s));
        temps.add(new Temp(R.drawable.t));
        temps.add(new Temp(R.drawable.u));
        temps.add(new Temp(R.drawable.v));
        temps.add(new Temp(R.drawable.w));
        temps.add(new Temp(R.drawable.x));
        temps.add(new Temp(R.drawable.y));
        temps.add(new Temp(R.drawable.z));
        return temps;
    }
    private void gropeBottom() {
        bPley = findViewById(R.id.bPlay);

        handler = new Handler();

        seekBar = findViewById(R.id.seekBar);
    }

    private void setPlayer() {
        player = MediaPlayer.create(this, R.raw.abc);

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
                    case R.id.bPlay:
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
}
