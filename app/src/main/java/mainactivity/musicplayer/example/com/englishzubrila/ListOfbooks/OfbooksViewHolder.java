package mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.R;

class OfbooksViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public OfbooksViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tView);
    }

    public void bind(final Spisoc spisoc) {
        textView.setText(spisoc.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spisoc.getName();
            }
        });
    }
}
