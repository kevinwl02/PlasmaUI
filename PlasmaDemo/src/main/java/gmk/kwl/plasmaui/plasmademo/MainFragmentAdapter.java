package gmk.kwl.plasmaui.plasmademo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Kevin Wong on 18/10/14.
 */
public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new AutoFragment();
        else
            return new DynamicFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
