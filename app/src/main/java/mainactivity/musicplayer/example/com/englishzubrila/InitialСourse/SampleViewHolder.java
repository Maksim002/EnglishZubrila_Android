package mainactivity.musicplayer.example.com.englishzubrila.InitialСourse;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.R;

class SampleViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public SampleViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView3);
    }

    public void bind(Context context) {
        textView.setText(context.getName() + "" + context.getNomer());
    }
}
