package torrent.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import torrent.tab.utils.MainTabView;
import torrent.tab.utils.TabUtils;

public class CustomTabActivity extends AppCompatActivity {


    @BindView(R.id.main_pager_vp)
    ViewPager viewPager;

    @BindView(R.id.main_tabLayout)
    MainTabView tabLayout;

    private MainViewPagerAdapter adapter;

    private Fragment[]mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);
        ButterKnife.bind(this);

        mFragments = TabUtils.getFragments();
        adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }


    class MainViewPagerAdapter extends FragmentPagerAdapter {

        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return  mFragments[0];
                case 1:
                    return mFragments[1];
                case 2:
                    return mFragments[2];
                default:
                    return mFragments[3];
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public static void start(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, CustomTabActivity.class);
            activity.startActivity(intent);
        }
    }
}
