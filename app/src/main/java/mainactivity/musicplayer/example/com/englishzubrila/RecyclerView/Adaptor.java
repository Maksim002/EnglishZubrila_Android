package mainactivity.musicplayer.example.com.englishzubrila.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Adaptor extends RecyclerView.Adapter<ResViewHolder> {

    private List<Content> contents;
    private Listener listener;

    public Adaptor(List<Content> contents, Listener listener) {
        this.contents = contents;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ResViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_initial,viewGroup,false);
        return new ResViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewHolder resViewHolder, int position) {
        resViewHolder.bind(contents.get(position));
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }
}
