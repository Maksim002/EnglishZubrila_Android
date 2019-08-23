package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Enum.Beginner;
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
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClikGaleri(getAdapterPosition(),product);
            }
        });
    }
}
