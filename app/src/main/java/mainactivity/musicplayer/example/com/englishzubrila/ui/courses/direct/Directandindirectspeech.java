package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.direct;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Directandindirectspeech extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_and_indirect_speech);

        toolbar = findViewById(R.id.toolDirect);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Direct and indirect");
    }
}
