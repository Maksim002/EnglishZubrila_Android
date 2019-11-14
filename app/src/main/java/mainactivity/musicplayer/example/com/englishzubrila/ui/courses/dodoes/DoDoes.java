package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.dodoes;

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

public class DoDoes extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPleyE, bPleyB, bPleyS, bPleyD, bPleyF, bPleyG, bPleyH;
    private SeekBar seekBarE, seekBarB, seekBarS, seekBarD, seekBarF, seekBarG, seekBarH;
    private MediaPlayer playerE, playerB, playerS, playerD, playerF, playerG, playerH;
    private Runnable runnableE, runnableB, runnableS, runnableD, runnableF, runnableG, runnableH;
    private Handler handlerE, handlerB, handlerS, handlerD, handlerF, handlerG, handlerH;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_does);

        toolbar = findViewById(R.id.toolDo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Do Does");

        getLessonA();
        getLessonE();
        getLessonI();
        getLessonO();
        getLessonU();
        getLessonY();
        getLessonHWA();
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
        bPleyE = findViewById(R.id.bPlayFi);

        handlerE = new Handler();

        seekBarE = findViewById(R.id.seekBarFi);

        playerE = MediaPlayer.create(this, R.raw.lesson_1);

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
                    case R.id.bPlayFi:
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
        bPleyB = findViewById(R.id.bPlayGi);

        handlerB = new Handler();

        seekBarB = findViewById(R.id.seekBarGi);

        playerB = MediaPlayer.create(this, R.raw.lesson_2);

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
                    case R.id.bPlayGi:
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

    private void getLessonI() {
        bPleyS = findViewById(R.id.bPlayHi);

        handlerS = new Handler();

        seekBarS = findViewById(R.id.seekBarHi);

        playerS = MediaPlayer.create(this, R.raw.lesson_3);

        playerS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarS.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarI();
                playerS.pause();
            }
        });
        seekBarS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
    private void changeSeekBarI() {
        seekBarS.setProgress(playerS.getCurrentPosition());

        if (playerS.isPlaying()) {
            runnableS = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarI();
                }
            };
            handlerS.postDelayed(runnableS, 1000);
        }
        bPleyS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayHi:
                        if (playerS.isPlaying()) {
                            playerS.pause();
                            bPleyS.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerS.start();
                            changeSeekBarI();
                            bPleyS.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonO() {
        bPleyD = findViewById(R.id.bPlayJi);

        handlerD = new Handler();

        seekBarD = findViewById(R.id.seekBarJi);

        playerD = MediaPlayer.create(this, R.raw.lesson_4);

        playerD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarD.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarO();
                playerD.pause();
            }
        });
        seekBarD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerD.seekTo(i);
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
        seekBarD.setProgress(playerD.getCurrentPosition());

        if (playerD.isPlaying()) {
            runnableD = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarO();
                }
            };
            handlerD.postDelayed(runnableD, 1000);
        }
        bPleyD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayJi:
                        if (playerD.isPlaying()) {
                            playerD.pause();
                            bPleyD.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerD.start();
                            changeSeekBarO();
                            bPleyD.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonU() {
        bPleyF = findViewById(R.id.bPlayKi);

        handlerF = new Handler();

        seekBarF = findViewById(R.id.seekBarKi);

        playerF = MediaPlayer.create(this, R.raw.lesson_5);

        playerF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarF.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarU();
                playerF.pause();
            }
        });
        seekBarF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerF.seekTo(i);
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
        seekBarF.setProgress(playerF.getCurrentPosition());

        if (playerF.isPlaying()) {
            runnableF = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarU();
                }
            };
            handlerF.postDelayed(runnableF, 1000);
        }
        bPleyF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayKi:
                        if (playerF.isPlaying()) {
                            playerF.pause();
                            bPleyF.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerF.start();
                            changeSeekBarU();
                            bPleyF.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonY() {
        bPleyG = findViewById(R.id.bPlayLi);

        handlerG = new Handler();

        seekBarG = findViewById(R.id.seekBarLi);

        playerG = MediaPlayer.create(this, R.raw.lesson_6);

        playerG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarG.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarY();
                playerG.pause();
            }
        });
        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerG.seekTo(i);
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
        seekBarG.setProgress(playerG.getCurrentPosition());

        if (playerG.isPlaying()) {
            runnableG = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarY();
                }
            };
            handlerG.postDelayed(runnableG, 1000);
        }
        bPleyG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayLi:
                        if (playerG.isPlaying()) {
                            playerG.pause();
                            bPleyG.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerG.start();
                            changeSeekBarY();
                            bPleyG.setImageResource(R.drawable.ic_pause_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonHWA() {
        bPleyH = findViewById(R.id.bPlayZi);

        handlerH = new Handler();

        seekBarH = findViewById(R.id.seekBarZi);

        playerH = MediaPlayer.create(this, R.raw.lesson_7);

        playerH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarH.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarHWA();
                playerH.pause();
            }
        });
        seekBarH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerH.seekTo(i);
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
    private void changeSeekBarHWA() {
        seekBarH.setProgress(playerH.getCurrentPosition());

        if (playerH.isPlaying()) {
            runnableH = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarHWA();
                }
            };
            handlerH.postDelayed(runnableH, 1000);
        }
        bPleyH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayZi:
                        if (playerH.isPlaying()) {
                            playerH.pause();
                            bPleyH.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerH.start();
                            changeSeekBarHWA();
                            bPleyH.setImageResource(R.drawable.ic_pause_black_24dp);
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
        handlerD.removeCallbacks(null);
        playerD.stop();
        handlerF.removeCallbacks(null);
        playerF.stop();
        handlerG.removeCallbacks(null);
        playerG.stop();
    }
}
