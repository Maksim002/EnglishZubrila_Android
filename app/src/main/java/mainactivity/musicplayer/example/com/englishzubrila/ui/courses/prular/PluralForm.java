package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.prular;

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

public class PluralForm extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPleyBq, bPleyBw, bPleyBe, bPleyBr, bPleyBt, bPleyBy, bPleyBu;
    private SeekBar seekBarBq, seekBarBw, seekBarBe, seekBarBr, seekBarBt, seekBarBy, seekBarBu;
    private MediaPlayer playerBq, playerBw, playerBe, playerBr, playerBt, playerBy, playerBu;
    private Runnable runnableBq, runnableBw, runnableBe, runnableBr, runnableBt, runnableBy, runnableBu;
    private Handler handlerBq, handlerBw, handlerBe, handlerBr, handlerBt, handlerBy, handlerBu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prular_form);

        toolbar = findViewById(R.id.toolbarAlphabet1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Plural Form");

        getLessonA();
        getLessonE();
        getLessonI();
        getLessonO();
        getLessonU();
        getLessonY();
        getLessonJ();
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
        bPleyBq = findViewById(R.id.bPlayEp);

        handlerBq = new Handler();

        seekBarBq = findViewById(R.id.seekBarEp);

        playerBq = MediaPlayer.create(this, R.raw.man);

        playerBq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarBq.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarA();
                playerBq.pause();
            }
        });
        seekBarBq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerBq.seekTo(i);
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
        seekBarBq.setProgress(playerBq.getCurrentPosition());

        if (playerBq.isPlaying()) {
            runnableBq = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarA();
                }
            };
            handlerBq.postDelayed(runnableBq, 1000);
        }
        bPleyBq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayEp:
                        if (playerBq.isPlaying()) {
                            playerBq.pause();
                            bPleyBq.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBq.start();
                            changeSeekBarA();
                            bPleyBq.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }
    private void getLessonE() {
        bPleyBw = findViewById(R.id.bPlayEp);

        handlerBw = new Handler();

        seekBarBw = findViewById(R.id.seekBarEp);

        playerBw = MediaPlayer.create(this, R.raw.men);

        playerBw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarBw.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarE();
                playerBw.pause();
            }
        });
        seekBarBw.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerBw.seekTo(i);
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
        seekBarBw.setProgress(playerBw.getCurrentPosition());

        if (playerBw.isPlaying()) {
            runnableBw = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarE();
                }
            };
            handlerBw.postDelayed(runnableBw, 1000);
        }
        bPleyBw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayEp:
                        if (playerBw.isPlaying()){
                            playerBw.pause();
                            bPleyBw.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBw.start();
                            changeSeekBarE();
                            bPleyBw.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }

        });
    }
    private void getLessonI() {
        bPleyBe = findViewById(R.id.bPlayFp);

        handlerBe = new Handler();

        seekBarBe = findViewById(R.id.seekBarFp);

        playerBe = MediaPlayer.create(this, R.raw.woman);

        playerBe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarBe.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarI();
                playerBe.pause();
            }
        });
        seekBarBe.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerBw.seekTo(i);
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
    private void changeSeekBarI() {
        seekBarBe.setProgress(playerBe.getCurrentPosition());

        if (playerBe.isPlaying()) {
            runnableBe = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarI();
                }
            };
            handlerBe.postDelayed(runnableBe, 1000);
        }
        bPleyBe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayFp:
                        if (playerBe.isPlaying()) {
                            playerBe.pause();
                            bPleyBe.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBe.start();
                            changeSeekBarI();
                            bPleyBe.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonO() {
        bPleyBr = findViewById(R.id.bPlayDp);

        handlerBr = new Handler();

        seekBarBr = findViewById(R.id.seekBarDp);

        playerBr = MediaPlayer.create(this, R.raw.woman);

        playerBr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarBr.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarO();
                playerBr.pause();
            }
        });
        seekBarBr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerBr.seekTo(i);
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
    private void changeSeekBarO() {
        seekBarBr.setProgress(playerBr.getCurrentPosition());

        if (playerBr.isPlaying()) {
            runnableBr = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarO();
                }
            };
            handlerBr.postDelayed(runnableBr, 1000);
        }
        bPleyBr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayDp:
                        if (playerBr.isPlaying()) {
                            playerBr.pause();
                            bPleyBr.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBr.start();
                            changeSeekBarO();
                            bPleyBr.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }
    private void getLessonU() {
        bPleyBt = findViewById(R.id.bPlayNp);

        handlerBt = new Handler();

        seekBarBt = findViewById(R.id.seekBarNp);

        playerBt = MediaPlayer.create(this, R.raw.women);

        playerBt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarBt.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarU();
                playerBt.pause();
            }
        });
        seekBarBt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
    private void changeSeekBarU() {
        seekBarBt.setProgress(playerBt.getCurrentPosition());

        if (playerBt.isPlaying()) {
            runnableBt = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarU();
                }
            };
            handlerBt.postDelayed(runnableBt, 1000);
        }
        bPleyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayNp:
                        if (playerBt.isPlaying()) {
                            playerBt.pause();
                            bPleyBt.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBt.start();
                            changeSeekBarU();
                            bPleyBt.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }
    private void getLessonY() {
        bPleyBy = findViewById(R.id.bPlayIp);

        handlerBy = new Handler();

        seekBarBy = findViewById(R.id.seekBarIp);

        playerBy = MediaPlayer.create(this, R.raw.lesson8_num1);

        playerBy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarBy.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarY();
                playerBy.pause();
            }
        });
        seekBarBy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerBy.seekTo(i);
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
    private void changeSeekBarY() {
        seekBarBy.setProgress(playerBy.getCurrentPosition());

        if (playerBy.isPlaying()) {
            runnableBy = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarY();
                }
            };
            handlerBy.postDelayed(runnableBy, 1000);
        }
        bPleyBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayIp:
                        if (playerBy.isPlaying()) {
                            playerBy.pause();
                            bPleyBy.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBy.start();
                            changeSeekBarY();
                            bPleyBy.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }
    private void getLessonJ() {
        bPleyBu = findViewById(R.id.bPlayJp);

        handlerBu = new Handler();

        seekBarBu = findViewById(R.id.seekBarJp);

        playerBu = MediaPlayer.create(this, R.raw.lesson8_num2);

        playerBu.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarBu.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarJ();
                playerBu.pause();
            }
        });
        seekBarBu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerBu.seekTo(i);
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
    private void changeSeekBarJ() {
        seekBarBu.setProgress(playerBu.getCurrentPosition());

        if (playerBu.isPlaying()) {
            runnableBu = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarJ();
                }
            };
            handlerBu.postDelayed(runnableBu, 1000);
        }
        bPleyBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayJp:
                        if (playerBu.isPlaying()) {
                            playerBu.pause();
                            bPleyBu.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerBu.start();
                            changeSeekBarY();
                            bPleyBu.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handlerBq.removeCallbacks(null);
        playerBq.stop();
        handlerBw.removeCallbacks(null);
        playerBw.stop();
        handlerBe.removeCallbacks(null);
        playerBe.stop();
        handlerBr.removeCallbacks(null);
        playerBr.stop();
        handlerBt.removeCallbacks(null);
        playerBt.stop();
        handlerBy.removeCallbacks(null);
        playerBy.stop();
        handlerBu.removeCallbacks(null);
        playerBu.stop();
    }
}
