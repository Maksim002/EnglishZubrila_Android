package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.galeryadaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.model.Gallery;

public class GalleryViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;
    private LinearLayout linearLayout;

    public GalleryViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.galleryText);
        linearLayout = itemView.findViewById(R.id.layoutColor);
    }

    public void bind(Gallery path) {
        textView.setText(path.getName());
        linearLayout.setBackgroundColor(path.getColor());

        Glide.with(imageView).load(path.getImages())
                .apply(new RequestOptions())
                .transform(new CenterCrop(),
                    new RoundedCorners(10))
                .into(imageView);
    }
}
