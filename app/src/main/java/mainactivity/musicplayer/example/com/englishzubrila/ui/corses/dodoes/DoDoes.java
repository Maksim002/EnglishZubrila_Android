package mainactivity.musicplayer.example.com.englishzubrila.ui.corses.dodoes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class DoDoes extends AppCompatActivity {

    private ImageView bPley,bPley2,bPley3,bPley4,bPley5,bPley6,bPley7;
    private SeekBar seekBar1, seekBar2,seekBar3,seekBar4,seekBar5,seekBar6,seekBar7;
    private MediaPlayer player1, player2,player3,player4,player5,player6,player7;
    private Runnable runnable1, runnable2,runnable3,runnable4,runnable5,runnable6,runnable7;
    private Handler handler1, handler2,handler3,handler4,handler5,handler6,handler7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_does);

        getLessonA();
        getLessonE();
        getLessonI();
        getLessonO();
        getLessonU();
        getLessonY();
        getLessonHWA();
    }

    private void getLessonA() {
        bPley = findViewById(R.id.bPlay0);

        handler1 = new Handler();

        seekBar1 = findViewById(R.id.seekBar0);

        player1 = MediaPlayer.create(this, R.raw.lesson_1);

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
        bPley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay0:
                        if (player1.isPlaying()) {
                            player1.pause();
                            bPley.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player1.start();
                            changeSeekBarA();
                            bPley.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonE() {
        bPley2 = findViewById(R.id.bPlay1);

        handler2 = new Handler();

        seekBar2 = findViewById(R.id.seekBar1);

        player2 = MediaPlayer.create(this, R.raw.lesson_2);

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

    private void getLessonI() {
        bPley3 = findViewById(R.id.bPlay2);

        handler3 = new Handler();

        seekBar3 = findViewById(R.id.seekBar2);

        player3 = MediaPlayer.create(this, R.raw.lesson_3);

        player3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar3.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarI();
                player3.pause();
            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
    private void changeSeekBarI() {
        seekBar3.setProgress(player3.getCurrentPosition());

        if (player3.isPlaying()) {
            runnable3 = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarI();
                }
            };
            handler3.postDelayed(runnable3, 1000);
        }
        bPley3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay2:
                        if (player3.isPlaying()) {
                            player3.pause();
                            bPley3.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player3.start();
                            changeSeekBarI();
                            bPley3.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonO() {
        bPley4 = findViewById(R.id.bPlay3);

        handler4 = new Handler();

        seekBar4 = findViewById(R.id.seekBar3);

        player4 = MediaPlayer.create(this, R.raw.lesson_4);

        player4.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar4.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarO();
                player4.pause();
            }
        });
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player4.seekTo(i);
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
        seekBar4.setProgress(player4.getCurrentPosition());

        if (player4.isPlaying()) {
            runnable4 = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarO();
                }
            };
            handler4.postDelayed(runnable4, 1000);
        }
        bPley4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay3:
                        if (player4.isPlaying()) {
                            player4.pause();
                            bPley4.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player4.start();
                            changeSeekBarO();
                            bPley4.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonU() {
        bPley5 = findViewById(R.id.bPlay4);

        handler5 = new Handler();

        seekBar5 = findViewById(R.id.seekBar4);

        player5 = MediaPlayer.create(this, R.raw.lesson_5);

        player5.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar5.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarU();
                player5.pause();
            }
        });
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player5.seekTo(i);
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
        seekBar5.setProgress(player5.getCurrentPosition());

        if (player5.isPlaying()) {
            runnable5 = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarU();
                }
            };
            handler5.postDelayed(runnable5, 1000);
        }
        bPley5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay4:
                        if (player5.isPlaying()) {
                            player5.pause();
                            bPley5.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player5.start();
                            changeSeekBarU();
                            bPley5.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonY() {
        bPley6 = findViewById(R.id.bPlay5);

        handler6 = new Handler();

        seekBar6 = findViewById(R.id.seekBar5);

        player6 = MediaPlayer.create(this, R.raw.lesson_6);

        player6.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar6.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarY();
                player6.pause();
            }
        });
        seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player6.seekTo(i);
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
        seekBar6.setProgress(player6.getCurrentPosition());

        if (player6.isPlaying()) {
            runnable6 = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarY();
                }
            };
            handler6.postDelayed(runnable6, 1000);
        }
        bPley6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay5:
                        if (player6.isPlaying()) {
                            player6.pause();
                            bPley6.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player6.start();
                            changeSeekBarY();
                            bPley6.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonHWA() {
        bPley7 = findViewById(R.id.bPlay6);

        handler7 = new Handler();

        seekBar7 = findViewById(R.id.seekBar6);

        player7 = MediaPlayer.create(this, R.raw.lesson_7);

        player7.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar7.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarHWA();
                player7.pause();
            }
        });
        seekBar7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    player7.seekTo(i);
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
        seekBar7.setProgress(player7.getCurrentPosition());

        if (player7.isPlaying()) {
            runnable7 = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarHWA();
                }
            };
            handler7.postDelayed(runnable7, 1000);
        }
        bPley7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlay6:
                        if (player7.isPlaying()) {
                            player7.pause();
                            bPley7.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            player7.start();
                            changeSeekBarHWA();
                            bPley7.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        player1.stop();
        player2.stop();
        player3.stop();
        player4.stop();
        player5.stop();
        player7.stop();
    }
}
