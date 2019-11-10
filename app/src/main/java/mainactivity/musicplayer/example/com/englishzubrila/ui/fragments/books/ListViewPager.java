package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.adapter.Adapter;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.adapter.animpager.ZoomOutTransformation;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.model.Model;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.model.web.WebViewB;
import mainactivity.musicplayer.example.com.englishzubrila.ui.home.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.R;


public class ListViewPager extends Fragment implements Listener {

    private ViewPager viewPager;
    private Adapter adapter;
    private Integer[] colors = null;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private List<Model> list;

    private ImageView imageRate, imageRateB, imageLeftE,imageLeft;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_view_pager, container, false);

        viewPager = view.findViewById(R.id.viewPager);

        imageLeft = view.findViewById(R.id.imageLeft);
        imageRate = view.findViewById(R.id.imageRate);
        imageLeftE = view.findViewById(R.id.imageListLeft);
        imageRateB = view.findViewById(R.id.imageListRate);

        imageRateB.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.anim_rate));
        imageRate.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.anim_rate));
        imageLeftE.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.anim_left));
        imageLeft.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.anim_left));

        imageRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == adapter.getCount() - 1){
                } else viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        imageRateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == adapter.getCount() - 1){
                } else viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == adapter.getCount() + 1){
                } else viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        imageLeftE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == adapter.getCount() + 1){
                } else viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

        getCompanies();
        return view;
    }
    private void getCompanies(){
            list = new ArrayList<>();
            list.add(new Model(R.drawable.kilers,"Эрнест Хэмингуэй. Киллеры",R.string.kilers,"https://drive.google.com/open?id=1SWcocqAqJ_qa9xqLBBe5RloLW7YyoR0G"));
            list.add(new Model(R.drawable.the_third_man,"The Third Man - Третий человек",R.string.The_Third_Man,"https://drive.google.com/open?id=1CmuofozQFj8G02RgKljcp-GExNWOTP6t"));
            list.add(new Model(R.drawable.a_sound_of_thunder,"И грянул гром - A Sound of Thunder",R.string.a_sound_of_thunder,"https://drive.google.com/open?id=16outXzpBroYtH4pdjAim5Ce9kF_-nG6Q"));
            list.add(new Model(R.drawable.scazki,"Ирландские волшебные сказки - Irish Fairy Tales",R.string.Irish_Fairy_Tales,"https://drive.google.com/open?id=13QjbIrWaBWSHijavyAuInclzYSUhfm6K"));
            list.add(new Model(R.drawable.besmaslesa,"A Book of Nonsense - Книга бессмыслицы",R.string.of_Nonsense,"https://drive.google.com/open?id=1dEMThCOWc2qdQ-seLOixIurshU_fmFld"));
            list.add(new Model(R.drawable.socol,"The Maltese Falcon - Мальтийский сокол",R.string.socol,"https://drive.google.com/open?id=1bhstB3urysUCuIPG4EdJmzyFSBL2uO1c"));
            list.add(new Model(R.drawable.ostrov," Остров сокровищ - Treasure Island",R.string.ostrov,"https://drive.google.com/open?id=1pDISoESI2AGtGx0w55KCd3xWnOELD8CU"));
            list.add(new Model(R.drawable.robert,"Английский язык с Конаном Роберт Говард",R.string.Robert_E_Howard,"https://drive.google.com/open?id=1Ygq1yOi80opJxxXJ88cxmk1gHXyBvM2X"));
            list.add(new Model(R.drawable.gandalf,"Портобелло Роуд - The Portobello Road",R.string.The_Portobello,"https://drive.google.com/open?id=1w_MjrS6OtRw0Hg18XSLIuyRz8AvS3gmP"));
            list.add(new Model(R.drawable.walliam,"Театр - Theatre",R.string.somerset,"https://drive.google.com/open?id=1bPWaQxFWLrKtjsnXdKT9S79PF9-IQy2e"));
            list.add(new Model(R.drawable.zpage,"Robinson Crusoe - Робинзон Крузо",R.string.James,"https://drive.google.com/open?id=1Tvw134ijGeDJuJTP0FkUlcIZWD9tFK1f"));

            adapter = new Adapter(list,getContext(),this);

            viewPager.setAdapter(adapter);
            viewPager.setPadding(30, 0, 30, 0);

            ZoomOutTransformation zoomOutTransformation = new ZoomOutTransformation();
            viewPager.setPageTransformer(true, zoomOutTransformation);


        Integer[] colors_temp = {
                    getResources().getColor(R.color.colorBek),
            };
            colors = colors_temp;

            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (position < (adapter.getCount() - 1) && position < (colors.length - 1)){
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
    public void onClickGallery(int adapterPosition, Product product) {

    }
    @Override
    public void onClickGallery(Model model) {
        Intent intent = new Intent(getContext(), WebViewB.class);
        intent.putExtra("Web", model);
        startActivity(intent);
    }
}
