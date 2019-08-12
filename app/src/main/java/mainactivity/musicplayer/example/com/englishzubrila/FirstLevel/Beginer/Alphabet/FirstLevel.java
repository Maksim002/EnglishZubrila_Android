package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet.CatalogFragmentov.FirsstFragment2;
import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet.CatalogFragmentov.FirstFragment;
import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet.CatalogFragmentov.FirstFragment1;
import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Content;

public class FirstLevel extends AppCompatActivity {

    private VerticalViewPager verticalViewPager;
    private PagerAdapter pagerAdapter;

    public static final String Level = "move";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_level);

        Content content = getIntent().getParcelableExtra(FirstLevel.Level);

        List<Fragment> list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new FirstFragment1());
        list.add(new FirsstFragment2());

        verticalViewPager = findViewById(R.id.verticalPager);
        pagerAdapter = new VerticalPagerAdaptor(getSupportFragmentManager(),list);

        verticalViewPager.setAdapter(pagerAdapter);
    }
}
