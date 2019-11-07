package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.expandable;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.model.Company;

public class CompanyViewHolder extends GroupViewHolder {
    private ImageView imageView1;
    private TextView textHeadline;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        imageView1 = itemView.findViewById(R.id.imageOp);
        textHeadline = itemView.findViewById(R.id.textHeadline);
    }
    public void bind(Company company) {
        imageView1.setImageResource(company.getImage());
        textHeadline.setText(company.getHeadline());
    }
}
