package mainactivity.musicplayer.example.com.englishzubrila.Moterial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Adaptor extends RecyclerView.Adapter<GaleryViewHolder> {

    private Listener listener;
    private List<Contact> contact;

    public Adaptor(Listener listener, List<Contact> contact) {
        this.listener = listener;
        this.contact = contact;
    }

    @NonNull
    @Override
    public GaleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_initial, viewGroup, false);
        return new GaleryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final GaleryViewHolder galeryViewHolder,int position) {
        galeryViewHolder.bind(contact.get(position));

    }

    @Override
    public int getItemCount() {
        return contact.size();
    }
}
