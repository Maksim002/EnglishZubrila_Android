package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class VerticalPage implements ViewPager.PageTransformer {

    @Override
    public void transformPage(@NonNull View view, float position) {
        if (position < -1){
            view.setAlpha(0);
        }else if (position <=1){
            view.setAlpha(1);
            view.setTranslationX(view.getWidth() * -position);
            float yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);
        }else {
            view.setAlpha(0);
        }
    }
}
