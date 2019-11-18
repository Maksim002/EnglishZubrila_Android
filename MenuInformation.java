package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.Information;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class MenuInformation extends AppCompatActivity {
    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        toolbar = findViewById(R.id.toolMenu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitle("O приложении");
        setSupportActionBar(toolbar);
    }
}
