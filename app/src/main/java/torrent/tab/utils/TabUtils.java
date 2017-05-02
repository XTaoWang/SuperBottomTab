package torrent.tab.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import torrent.tab.R;
import torrent.tab.fragment.CouponFragment;
import torrent.tab.fragment.FindFragment;
import torrent.tab.fragment.HomeFragment;
import torrent.tab.fragment.MeFragment;

/**
 * Author:  Wang Tao
 * Email:   6190171759@qq.com | torrent.wang@gmail.com
 * Date:    2017/5/2.
 * Description:
 */

public class TabUtils {

    public static final int []mTabRes = new int[]{
            R.drawable.icon_tab_home,
            R.drawable.icon_tab_card,
            R.drawable.icon_tab_coupon,
            R.drawable.icon_tab_me};
    public static final int []mTabResPressed = new int[]{
            R.drawable.icon_tab_home_selected,
            R.drawable.icon_tab_card_selected,
            R.drawable.icon_tab_coupon_selected,
            R.drawable.icon_tab_me_selected};
    public static final String []mTabTitle = new String[]{"首页","发现","关注","我的"};

    public static Fragment[] getFragments(){
        Fragment fragments[] = new Fragment[4];
        fragments[0] = HomeFragment.newInstance("HomeFragment");
        fragments[1] = FindFragment.newInstance("FindFragment");
        fragments[2] = CouponFragment.newInstance("CouponFragment.");
        fragments[3] = MeFragment.newInstance("MeFragment");
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content,null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(TabUtils.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}
