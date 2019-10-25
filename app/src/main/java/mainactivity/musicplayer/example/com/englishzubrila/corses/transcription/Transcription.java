package mainactivity.musicplayer.example.com.englishzubrila.corses.transcription;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import at.blogc.android.views.ExpandableTextView;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Transcription extends AppCompatActivity {
    private ExpandableTextView expandableTextView1, expandableTextView2, expandableTextView3;
    private TextView link;

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPley1,bPley2,bPley3,bPley4,bPley5,bPley6,bPley7;
    private SeekBar seekBar1, seekBar2,seekBar3,seekBar4,seekBar5,seekBar6,seekBar7;
    private MediaPlayer player1, player2,player3,player4,player5,player6,player7;
    private Runnable runnable1, runnable2,runnable3,runnable4,runnable5,runnable6,runnable7;
    private Handler handler1, handler2,handler3,handler4,handler5,handler6,handler7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcription);

        toolbar = findViewById(R.id.toolbarTranscription);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Transcription");

        getExpandableTextView1();
        getExpandableTextView2();
        getExpandableTextView3();

        getLink();

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
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    private void getExpandableTextView1() {
        expandableTextView1 = findViewById(R.id.exText1);

        expandableTextView1.setAnimationDuration(5L);
        expandableTextView1.setInterpolator(new OvershootInterpolator());

        expandableTextView1.setExpandInterpolator(new OvershootInterpolator());
        expandableTextView1.setCollapseInterpolator(new OvershootInterpolator());

        expandableTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextView1.setText(expandableTextView1.isExpanded() ? R.string._1 : R.string._1_cal);
                expandableTextView1.toggle();
            }
        });
        expandableTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableTextView1.isExpanded()) {
                    expandableTextView1.collapse();
                    expandableTextView1.setText(R.string._1);
                } else {
                    expandableTextView1.expand();
                    expandableTextView1.setText(R.string._1_cal);
                }
            }
        });
    }

    private void getExpandableTextView2() {
        expandableTextView2 = findViewById(R.id.exText2);

        expandableTextView2.setAnimationDuration(5L);
        expandableTextView2.setInterpolator(new OvershootInterpolator());

        expandableTextView2.setExpandInterpolator(new OvershootInterpolator());
        expandableTextView2.setCollapseInterpolator(new OvershootInterpolator());

        expandableTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextView2.setText(expandableTextView2.isExpanded() ? R.string._2 : R.string._2_cal);
                expandableTextView2.toggle();
            }
        });
        expandableTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableTextView2.isExpanded()) {
                    expandableTextView2.collapse();
                    expandableTextView2.setText(R.string._2);
                } else {
                    expandableTextView2.expand();
                    expandableTextView2.setText(R.string._2_cal);
                }
            }
        });
    }

    private void getExpandableTextView3() {
        expandableTextView3 = findViewById(R.id.exText3);

        expandableTextView3.setAnimationDuration(5L);
        expandableTextView3.setInterpolator(new OvershootInterpolator());

        expandableTextView3.setExpandInterpolator(new OvershootInterpolator());
        expandableTextView3.setCollapseInterpolator(new OvershootInterpolator());

        expandableTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextView3.setText(expandableTextView3.isExpanded() ? R.string._3 : R.string._3_cal);
                expandableTextView3.toggle();
            }
        });
        expandableTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableTextView3.isExpanded()) {
                    expandableTextView3.collapse();
                    expandableTextView3.setText(R.string._3);
                } else {
                    expandableTextView3.expand();
                    expandableTextView3.setText(R.string._3_cal);
                }
            }
        });
    }

    private void getLessonA() {
            bPley1 = findViewById(R.id.b);

            handler1 = new Handler();

            seekBar1 = findViewById(R.id.seekBar1);

            player1 = MediaPlayer.create(this, R.raw.lessona);

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
                        case R.id.b:
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
        bPley2 = findViewById(R.id.b);

        handler2 = new Handler();

        seekBar2 = findViewById(R.id.seekBar1);

        player2 = MediaPlayer.create(this, R.raw.lessone);

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
                    case R.id.b:
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

        player3 = MediaPlayer.create(this, R.raw.lessoni);

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

        seekBar4 = findViewById(R.id.seekBar4);

        player4 = MediaPlayer.create(this, R.raw.lessono);

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

        seekBar5 = findViewById(R.id.seekBar5);

        player5 = MediaPlayer.create(this, R.raw.lessonu);

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

        player6 = MediaPlayer.create(this, R.raw.lessony);

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

        player7 = MediaPlayer.create(this, R.raw.lessonschwa);

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

    private void getLink(){
        link = findViewById(R.id.link);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.link:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://realstudy.ru/moodle/mod/book/view.php?id=2027&chapterid=2"));
                        startActivity(intent);
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


