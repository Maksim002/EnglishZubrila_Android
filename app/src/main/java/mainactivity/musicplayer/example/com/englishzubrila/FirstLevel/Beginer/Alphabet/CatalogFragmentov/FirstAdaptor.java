package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet.CatalogFragmentov;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class FirstAdaptor extends RecyclerView.Adapter<FirstViewHolder> {
    private List<Temp> temps;

    public FirstAdaptor(FirsstFragment2 firsstFragment2, List<Temp> temps) {
        this.temps = temps;
    }

    @NonNull
    @Override
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_forsst_fragment2, viewGroup, false);
        return new FirstViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstViewHolder firstViewHolder, int position) {
        firstViewHolder.bind(temps.get(position));
    }

    @Override
    public int getItemCount() {
        return temps.size();
    }
}
