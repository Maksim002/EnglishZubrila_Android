package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.simple;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.simple.pager.Adaptor;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.simple.pager.Model;

public class PresentSimple extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    private ViewPager viewPager;
    private Adaptor adaptor;
    private Integer[] colors = null;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private List<Model> list;
    private ImageView imageSampleE, imageSampleB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_simple);

        toolbar = findViewById(R.id.toolSimple);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Present Simple");

        imageSampleE = findViewById(R.id.imageSampleE);
        imageSampleB = findViewById(R.id.imageSampleB);

        Animation animationSampleD = AnimationUtils.loadAnimation(this, R.anim.anim_rate_simple);
        imageSampleB.startAnimation(animationSampleD);
        Animation animationSamplej = AnimationUtils.loadAnimation(this, R.anim.anim_rate_simple);
        imageSampleE.startAnimation(animationSamplej);

        list = new ArrayList<>();
        list.add(new Model(R.drawable.pos_e));
        list.add(new Model(R.drawable.pos_b));
        list.add(new Model(R.drawable.pos_s));

        adaptor = new Adaptor(list, this);

        viewPager = findViewById(R.id.viewPagerSimple);
        viewPager.setAdapter(adaptor);

        viewPager.setPadding(0, 0, 0, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
        };


        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adaptor.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}