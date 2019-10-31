package mainactivity.musicplayer.example.com.englishzubrila.ui.corses.alphabet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import mainactivity.musicplayer.example.com.englishzubrila.R;

class FirstViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public FirstViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageViewDizaneFragment2);
    }

    public void bind(Temp temp) {
        imageView.setImageResource(temp.getTemp(getAdapterPosition()));
    }
}
