package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.heatsheets.galeryadaptor;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class GalleryPegerAdaptar extends PagerAdapter {
    private List<String> list = new ArrayList<>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        View view = layoutInflater.inflate(R.layout.item_peger_gallery, container, false);
        GalleryPegerViewHolder holder = new GalleryPegerViewHolder(view);
        holder.bind(list.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }
    public void updeteList(List<String> list){
        this.list = list;
        notifyDataSetChanged();

    }
}