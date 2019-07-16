package mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Content;

public class PhilipChesterfield extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static final String move = "Philip Chesterfield - Letters to his Son";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philip_chesterfield);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

     recyclerView = findViewById(R.id.recycler_philip_chesterfield);
     recyclerView.setAdapter(new OfbooksAdapter(this, getContact()));

     Spisoc spisoc = getIntent().getParcelableExtra(PhilipChesterfield.move);

    }
    List<Spisoc> getContact() {
        List<Spisoc> list = new ArrayList<>();
        list.add(new Spisoc(getString(R.string.text_rus)));
        list.add(new Spisoc("EEF"));
        return list;
    }
}
