package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.galeryadaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.model.Gallery;
import mainactivity.musicplayer.example.com.englishzubrila.ui.home.Listener;

public class GalleryAdaptar extends RecyclerView.Adapter<GalleryViewHolder> {
    private List<Gallery> list = new ArrayList<>();
    private Listener listener;

    public GalleryAdaptar(Listener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_gallery, viewGroup, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GalleryViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickGallery(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  void setGalleryList(List<Gallery> newDate){
        this.list = newDate;
        notifyDataSetChanged();
    }
}
