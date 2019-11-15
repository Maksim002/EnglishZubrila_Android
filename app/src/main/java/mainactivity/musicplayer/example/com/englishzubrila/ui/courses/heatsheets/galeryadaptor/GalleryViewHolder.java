package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.heatsheets.galeryadaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class GalleryViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public GalleryViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void bind(String path) {
        Glide.with(imageView).load(path)
                .apply(new RequestOptions())
                .transform(new CenterCrop(),
                    new RoundedCorners(10))
                .override(125,125)
                .into(imageView);
    }
}
