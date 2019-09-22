package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.ContenetListViewPager.Adaptor;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.ContenetListViewPager.Model;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.Product;
import mainactivity.musicplayer.example.com.englishzubrila.R;


public class ListViewPager extends Fragment implements Listener {

    private ViewPager viewPager;
    private Adaptor adaptor;
    private Integer[] colors = null;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private List<Model> list;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_view_pager, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Books");


        viewPager = view.findViewById(R.id.viewPager);

        getCompanies();
        return view;
    }

        private void getCompanies(){
            list = new ArrayList<>();
            list.add(new Model(R.drawable.kilers,"Эрнест Хэмингуэй. Киллеры",R.string.kilers,"https://drive.google.com/open?id=1SWcocqAqJ_qa9xqLBBe5RloLW7YyoR0G"));
            list.add(new Model(R.drawable.b,"Stec",R.string.to_be_to_be_be_am_m_are_is_iz,"https://drive.google.com/open?id=1jFbidxKvyUHpfrApgqT1XqXlEmVq7eYj"));
            list.add(new Model(R.drawable.v,"hmara",R.string.to_be_to_be_be_am_m_are_is_iz," https://drive.google.com/drive/u/0/folders/1qqMtGlwX2s515N4WjqwTIL_9aYhSWCf9"));
            list.add(new Model(R.drawable.c,"clara",R.string.to_be_to_be_be_am_m_are_is_iz,"https://drive.google.com/open?id=1SWcocqAqJ_qa9xqLBBe5RloLW7YyoR0G"));

            adaptor = new Adaptor(list,getContext(),this);


            viewPager.setAdapter(adaptor);
            viewPager.setPadding(50, 0, 50, 0);

            Integer[] colors_temp = {
                    getResources().getColor(R.color.color1),
                    getResources().getColor(R.color.color2),
                    getResources().getColor(R.color.color3),
                    getResources().getColor(R.color.color4),
            };

            colors = colors_temp;

            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (position < (adaptor.getCount() - 1) && position < (colors.length - 1)){
                        viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position],colors[position + 1]));
                    }else {
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



    @Override
    public void onClikGaleri(int adapterPosition, Product product) {

    }

    @Override
    public void onClikGaleri(Model model) {
        Intent intent = new Intent(getContext(), WebViewB.class);
        intent.putExtra("Web", model);
        startActivity(intent);
    }
}
