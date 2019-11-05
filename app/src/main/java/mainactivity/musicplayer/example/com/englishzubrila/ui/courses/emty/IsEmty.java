package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.emty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class IsEmty extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_emty);

        toolbar = findViewById(R.id.toolIs);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Is Empty");
    }
}
