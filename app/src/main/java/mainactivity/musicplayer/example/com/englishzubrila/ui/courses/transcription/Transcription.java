package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.transcription;

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
    private ExpandableTextView expandableTextViewE, expandableTextViewB, expandableTextViewS;
    private TextView link;

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ImageView bPlayerE, bPlayerB, bPlayerS, bPlayerD, bPlayerI, bPlayerF, bPlayerG;
    private SeekBar seekBarE, seekBarB, seekBarS, seekBarD, seekBarI, seekBarF, seekBarG;
    private MediaPlayer playerE, playerB, playerS, playerD, playerI, playerF, playerG;
    private Runnable runnableE, runnableB, runnableS, runnableD, runnableI, runnableF, runnableG;
    private Handler handlerE, handlerB, handlerS, handlerD, handlerI, handlerF, handlerJ;

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

        getExpandableTextViewE();
        getExpandableTextViewB();
        getExpandableTextViewS();

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
    private void getExpandableTextViewE() {
        expandableTextViewE = findViewById(R.id.exText1);

        expandableTextViewE.setAnimationDuration(5L);
        expandableTextViewE.setInterpolator(new OvershootInterpolator());

        expandableTextViewE.setExpandInterpolator(new OvershootInterpolator());
        expandableTextViewE.setCollapseInterpolator(new OvershootInterpolator());

        expandableTextViewE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextViewE.setText(expandableTextViewE.isExpanded() ? R.string._1 : R.string._1_cal);
                expandableTextViewE.toggle();
            }
        });
        expandableTextViewE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableTextViewE.isExpanded()) {
                    expandableTextViewE.collapse();
                    expandableTextViewE.setText(R.string._1);
                } else {
                    expandableTextViewE.expand();
                    expandableTextViewE.setText(R.string._1_cal);
                }
            }
        });
    }

    private void getExpandableTextViewB() {
        expandableTextViewB = findViewById(R.id.exText2);

        expandableTextViewB.setAnimationDuration(5L);
        expandableTextViewB.setInterpolator(new OvershootInterpolator());

        expandableTextViewB.setExpandInterpolator(new OvershootInterpolator());
        expandableTextViewB.setCollapseInterpolator(new OvershootInterpolator());

        expandableTextViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextViewB.setText(expandableTextViewB.isExpanded() ? R.string._2 : R.string._2_cal);
                expandableTextViewB.toggle();
            }
        });
        expandableTextViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableTextViewB.isExpanded()) {
                    expandableTextViewB.collapse();
                    expandableTextViewB.setText(R.string._2);
                } else {
                    expandableTextViewB.expand();
                    expandableTextViewB.setText(R.string._2_cal);
                }
            }
        });
    }

    private void getExpandableTextViewS() {
        expandableTextViewS = findViewById(R.id.exText3);

        expandableTextViewS.setAnimationDuration(5L);
        expandableTextViewS.setInterpolator(new OvershootInterpolator());

        expandableTextViewS.setExpandInterpolator(new OvershootInterpolator());
        expandableTextViewS.setCollapseInterpolator(new OvershootInterpolator());

        expandableTextViewS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextViewS.setText(expandableTextViewS.isExpanded() ? R.string._3 : R.string._3_cal);
                expandableTextViewS.toggle();
            }
        });
        expandableTextViewS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableTextViewS.isExpanded()) {
                    expandableTextViewS.collapse();
                    expandableTextViewS.setText(R.string._3);
                } else {
                    expandableTextViewS.expand();
                    expandableTextViewS.setText(R.string._3_cal);
                }
            }
        });
    }

    private void getLessonA() {
            bPlayerE = findViewById(R.id.bR);

            handlerE = new Handler();

            seekBarE = findViewById(R.id.seekBareR);

            playerE = MediaPlayer.create(this, R.raw.lessona);

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
            bPlayerE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.bR:
                            if (playerE.isPlaying()) {
                                playerE.pause();
                                bPlayerE.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                            } else {
                                playerE.start();
                                changeSeekBarA();
                                bPlayerE.setImageResource(R.drawable.ic_stop_black_24dp);
                            }
                            break;
                    }
                }
            });
        }

    private void getLessonE() {
        bPlayerB = findViewById(R.id.bT);

        handlerB = new Handler();

        seekBarB = findViewById(R.id.seekBarT);

        playerB = MediaPlayer.create(this, R.raw.lessone);

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
        bPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bT:
                        if (playerB.isPlaying()) {
                            playerB.pause();
                            bPlayerB.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerB.start();
                            changeSeekBarE();
                            bPlayerB.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonI() {
        bPlayerS = findViewById(R.id.bPlayY);

        handlerS = new Handler();

        seekBarS = findViewById(R.id.seekBarY);

        playerS = MediaPlayer.create(this, R.raw.lessoni);

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
        bPlayerS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayY:
                        if (playerS.isPlaying()) {
                            playerS.pause();
                            bPlayerS.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerS.start();
                            changeSeekBarI();
                            bPlayerS.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonO() {
        bPlayerD = findViewById(R.id.bPlayU);

        handlerD = new Handler();

        seekBarD = findViewById(R.id.seekBarU);

        playerD = MediaPlayer.create(this, R.raw.lessono);

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
        bPlayerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayU:
                        if (playerD.isPlaying()) {
                            playerD.pause();
                            bPlayerD.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerD.start();
                            changeSeekBarO();
                            bPlayerD.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonU() {
        bPlayerI = findViewById(R.id.bPlayI);

        handlerI = new Handler();

        seekBarI = findViewById(R.id.seekBarI);

        playerI = MediaPlayer.create(this, R.raw.lessonu);

        playerI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarI.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarU();
                playerI.pause();
            }
        });
        seekBarI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    playerI.seekTo(i);
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
        seekBarI.setProgress(playerI.getCurrentPosition());

        if (playerI.isPlaying()) {
            runnableI = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarU();
                }
            };
            handlerI.postDelayed(runnableI, 1000);
        }
        bPlayerI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayI:
                        if (playerI.isPlaying()) {
                            playerI.pause();
                            bPlayerI.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerI.start();
                            changeSeekBarU();
                            bPlayerI.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonY() {
        bPlayerF = findViewById(R.id.bPlayO);

        handlerF = new Handler();

        seekBarF = findViewById(R.id.seekBarO);

        playerF = MediaPlayer.create(this, R.raw.lessony);

        playerF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarF.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarY();
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
        private void changeSeekBarY() {
        seekBarF.setProgress(playerF.getCurrentPosition());

        if (playerF.isPlaying()) {
            runnableF = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarY();
                }
            };
            handlerF.postDelayed(runnableF, 1000);
        }
        bPlayerF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayO:
                        if (playerF.isPlaying()) {
                            playerF.pause();
                            bPlayerF.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerF.start();
                            changeSeekBarY();
                            bPlayerF.setImageResource(R.drawable.ic_stop_black_24dp);
                        }
                        break;
                }
            }
        });
    }

    private void getLessonHWA() {
        bPlayerG = findViewById(R.id.bPlayP);

        handlerJ = new Handler();

        seekBarG = findViewById(R.id.seekBarP);

        playerG = MediaPlayer.create(this, R.raw.lessonschwa);

        playerG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBarG.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekBarHWA();
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
        private void changeSeekBarHWA() {
        seekBarG.setProgress(playerG.getCurrentPosition());

        if (playerG.isPlaying()) {
            runnableG = new Runnable() {
                @Override
                public void run() {
                    changeSeekBarHWA();
                }
            };
            handlerJ.postDelayed(runnableG, 1000);
        }
        bPlayerG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bPlayP:
                        if (playerG.isPlaying()) {
                            playerG.pause();
                            bPlayerG.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        } else {
                            playerG.start();
                            changeSeekBarHWA();
                            bPlayerG.setImageResource(R.drawable.ic_stop_black_24dp);
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
        handlerI.removeCallbacks(null);
        playerI.stop();
        handlerF.removeCallbacks(null);
        playerF.stop();
        handlerJ.removeCallbacks(null);
        playerG.stop();
    }
}


