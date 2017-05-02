package torrent.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import torrent.tab.utils.TabUtils;

public class TabLayoutTabActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    private Fragment[] mFragmensts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_tab);

        mFragmensts = TabUtils.getFragments();

        mTabLayout = (TabLayout) findViewById(R.id.bottom_tab_layout);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());

                //改变Tab 状态
                for (int i = 0; i < mTabLayout.getTabCount(); i++) {

                    View view = mTabLayout.getTabAt(i).getCustomView();
                    ImageView icon = (ImageView) view.findViewById(R.id.tab_content_image);
                    TextView text = (TextView) view.findViewById(R.id.tab_content_text);

                    if (i == tab.getPosition()) {

                        icon.setImageResource(TabUtils.mTabResPressed[i]);
                        text.setTextColor(getResources().getColor(android.R.color.black));

                    } else {

                        icon.setImageResource(TabUtils.mTabRes[i]);
                        text.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for(int i=0;i<4;i++){
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(TabUtils.getTabView(this,i)));
        }

    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = mFragmensts[0];
                break;
            case 1:
                fragment = mFragmensts[1];
                break;

            case 2:
                fragment = mFragmensts[2];
                break;
            case 3:
                fragment = mFragmensts[3];
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }

    public static void start(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, TabLayoutTabActivity.class);
            activity.startActivity(intent);
        }
    }
}
