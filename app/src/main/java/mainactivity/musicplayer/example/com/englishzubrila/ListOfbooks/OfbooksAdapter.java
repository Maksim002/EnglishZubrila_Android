package mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Content;

public class OfbooksAdapter extends RecyclerView.Adapter<OfbooksViewHolder> {

   private List<Spisoc> list;


    public OfbooksAdapter(PhilipChesterfield philipChesterfield, List<Spisoc> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public OfbooksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_philip_chesterfield,viewGroup,false);
        return new OfbooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfbooksViewHolder ofbooksViewHolder, int position) {
        ofbooksViewHolder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
