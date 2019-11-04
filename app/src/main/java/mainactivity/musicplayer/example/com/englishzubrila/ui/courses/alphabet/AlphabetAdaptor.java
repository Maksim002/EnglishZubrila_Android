package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.alphabet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class AlphabetAdaptor extends RecyclerView.Adapter<AlphabetViewHolder> {
    private List<Temp> temps;

    public AlphabetAdaptor(Alphabet alphabet, List<Temp> temps) {
        this.temps = temps;
    }

    @NonNull
    @Override
    public AlphabetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_forsst_fragment2, viewGroup, false);
        return new AlphabetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetViewHolder firstViewHolder, int position) {
        firstViewHolder.bind(temps.get(position));
    }

    @Override
    public int getItemCount() {
        return temps.size();
    }
}
