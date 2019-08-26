package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import mainactivity.musicplayer.example.com.englishzubrila.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

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
