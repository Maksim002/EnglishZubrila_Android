package mainactivity.musicplayer.example.com.englishzubrila.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.R;

class ResViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;


    public ResViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView2);
    }

    public void bind(final Content content) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.getName();
            }
        });
    }
}
