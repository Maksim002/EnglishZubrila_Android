package mainactivity.musicplayer.example.com.englishzubrila.InitialСourse;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

class TestAdaptor extends RecyclerView.Adapter<SampleViewHolder> {

    private List<Context> context;

    public TestAdaptor(Initialcourse initialcourse, List<Context> context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_initial_dizane,viewGroup,false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder sampleViewHolder, int position) {
        sampleViewHolder.bind(context.get(position));
    }

    @Override
    public int getItemCount() {
        return context.size();
    }
}
