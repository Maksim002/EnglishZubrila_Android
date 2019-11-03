package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.simple.pager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Adaptor extends PagerAdapter {

    private List<Model> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adaptor(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_peg_simple, container,false);

        final ImageView imageView;

        imageView = view.findViewById(R.id.imageSample);

        imageView.setImageResource(list.get(position).getImage());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }
}
