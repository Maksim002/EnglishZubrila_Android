package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.expandable;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import mainactivity.musicplayer.example.com.englishzubrila.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.ui.home.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class ProductViewHolder extends ChildViewHolder {
    private TextView textView;
    private Listener listener;

    public ProductViewHolder(View itemView,Listener listener) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewProduct);
        this.listener = listener;
    }
    public void bind(final Product product){
        textView.setText(product.name);
        textView.setShadowLayer(30, 0, 0, Color.BLACK);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClikGaleri(getAdapterPosition(), product);
            }
        });
    }
}
