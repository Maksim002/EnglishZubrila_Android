package mainactivity.musicplayer.example.com.englishzubrila.initiFragment.expandable;

import android.view.View;
import android.widget.ImageView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class CompaniViewHolder extends GroupViewHolder {
    private ImageView imageView1;

    public CompaniViewHolder(View itemView) {
        super(itemView);
        imageView1 = itemView.findViewById(R.id.imageOp);
    }
    public void bind(Company company) {
        imageView1.setImageResource(company.getImage());
    }
}
