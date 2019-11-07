package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.model.Model;
import mainactivity.musicplayer.example.com.englishzubrila.ui.home.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Adapter extends PagerAdapter {

    private List<Model> list;
    private LayoutInflater layoutInflater;
    private Context context;
    private Listener listener;

    public Adapter(List<Model> list, Context context, Listener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
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
        View view = layoutInflater.inflate(R.layout.item_books, container,false);

        final ImageView imageView;
        TextView title, dsc;

        CardView cardView;

        imageView = view.findViewById(R.id.imageView);
        title = view.findViewById(R.id.title);
        dsc = view.findViewById(R.id.desc);

        cardView = view.findViewById(R.id.card_view);

        imageView.setImageResource(list.get(position).getImage());
        title.setText(list.get(position).getName());
        dsc.setText(list.get(position).getText());


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClikGaleri(list.get(position));
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }
}
