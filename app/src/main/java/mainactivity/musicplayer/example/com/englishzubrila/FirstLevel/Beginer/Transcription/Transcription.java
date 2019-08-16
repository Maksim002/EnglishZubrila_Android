package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Transcription;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import at.blogc.android.views.ExpandableTextView;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Transcription extends AppCompatActivity {
    private ExpandableTextView expandableTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcription);

        expandableTextView = findViewById(R.id.exText1);
        expandableTextView = findViewById(R.id.exText1);


        expandableTextView.setAnimationDuration(750L);
        expandableTextView.setInterpolator(new OvershootInterpolator());

        expandableTextView.setExpandInterpolator(new OvershootInterpolator());
        expandableTextView.setCollapseInterpolator(new OvershootInterpolator());

        expandableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextView.setText(expandableTextView.isExpanded() ? R.string._1 : R.string._1_cal);
                expandableTextView.toggle();
            }
        });
        expandableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableTextView.isExpanded())
                {
                    expandableTextView.collapse();
                    expandableTextView.setText(R.string._1);
                }
                else
                {
                    expandableTextView.expand();
                    expandableTextView.setText(R.string._1_cal);
                }
            }
        });
    }
}
