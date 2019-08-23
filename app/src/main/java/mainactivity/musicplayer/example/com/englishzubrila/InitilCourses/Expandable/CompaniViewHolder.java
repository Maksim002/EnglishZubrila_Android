package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import mainactivity.musicplayer.example.com.englishzubrila.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class CompaniViewHolder extends GroupViewHolder {
    private TextView textView;
    private ImageView imageView;
    private ImageView imageView1;

    public CompaniViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewCompany);
        imageView = itemView.findViewById(R.id.imageView4);
        imageView1 = itemView.findViewById(R.id.imageOp);
    }
    public void bind(Company company) {
        textView.setText(company.getTitle());
        imageView1.setImageResource(company.getImage());
    }

        @Override
        public void expand() {
            animateExpand();
        }

        @Override
        public void collapse() {
            animateCollapse();
        }

        private void animateExpand() {
            RotateAnimation rotate =
                    new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            imageView.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate =
                    new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            imageView.setAnimation(rotate);
        }

}
