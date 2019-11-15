package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.heatsheets.galeryadaptor;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class GalleryPegerViewHolder {
    private ImageView imageView;

    public GalleryPegerViewHolder(@NonNull View itemView) {
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void bind(String path) {
        Glide.with(imageView).load(path).into(imageView);
    }
}
