package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.galeryadaptor;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.model.Gallery;

public class GalleryPegerViewHolder {
    private ImageView imageView;

    public GalleryPegerViewHolder(@NonNull View itemView) {
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void bind(Gallery path) {
        Glide.with(imageView).load(path.getImages()).into(imageView);
    }
}
