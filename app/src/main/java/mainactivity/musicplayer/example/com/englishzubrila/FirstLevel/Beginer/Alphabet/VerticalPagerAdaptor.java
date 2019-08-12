package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class VerticalPagerAdaptor extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public VerticalPagerAdaptor(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
