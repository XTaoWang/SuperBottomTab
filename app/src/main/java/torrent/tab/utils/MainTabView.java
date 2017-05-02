package torrent.tab.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import torrent.tab.R;

/**
 * Author:  Wang Tao
 * Email:   6190171759@qq.com | torrent.wang@gmail.com
 * Date:    2017/5/2.
 * Description:
 */

public class MainTabView extends LinearLayout {

    private LayoutInflater layoutInflater;

    @BindView(R.id.main_bottom_tab_1_text)
    TextView tab1;

    @BindView(R.id.main_bottom_tab_2_text)
    TextView tab2;

    @BindView(R.id.main_bottom_tab_3_text)
    TextView tab3;


    @BindView(R.id.main_bottom_tab_4_text)
    TextView tab4;


    private List<TabInfo> mainTabInfoList;
    protected List<TextView> mainTabTexts;
    protected int[] mainTabContainers;

    private int currentIndex;
    private ViewPager viewPager;

    private OnTabClickListener onTabClickListener;

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.onTabClickListener = onTabClickListener;
    }

    public MainTabView(Context context) {
        super(context);
        init();
    }

    public MainTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MainTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public MainTabView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        layoutInflater = LayoutInflater.from(getContext());
        layoutInflater.inflate(R.layout.main_tab_view, this, true);
        ButterKnife.bind(this);
        mainTabInfoList = getHomeTabInfoList();
        mainTabTexts = new ArrayList<TextView>() {
            {
                add(tab1);
                add(tab2);
                add(tab3);
                add(tab4);
            }
        };
        mainTabContainers = new int[]
                {
                        R.id.main_bottom_tab_1,
                        R.id.main_bottom_tab_2,
                        R.id.main_bottom_tab_3,
                        R.id.main_bottom_tab_4,
                };
        initTabClickListener();
        setInitTab();
    }

    private void initTabClickListener() {
        for (int i = 0; i < mainTabContainers.length; i++) {
            View view = findViewById(mainTabContainers[i]);
            final int position = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    int lastIndex = currentIndex;
                    if (currentIndex != position) {
                        setTab(position);
                        viewPager.setCurrentItem(currentIndex);
                    }
                    if (onTabClickListener != null) {
                        onTabClickListener.onTabClick(view, currentIndex, lastIndex);
                    }
                }
            });
        }
    }

    public void setInitTab() {
        currentIndex = 0;
        for (int i = mainTabInfoList.size() - 1; i >= 0; i--) {
            setTab(i);
        }
    }

    public void setTab(int index) {
        setTab(mainTabTexts.get(currentIndex), mainTabInfoList.get(currentIndex), false);
        currentIndex = index;
        setTab(mainTabTexts.get(currentIndex), mainTabInfoList.get(currentIndex), true);
    }

    private void setTab(TextView tab, TabInfo info, boolean selected) {
        tab.setCompoundDrawablesWithIntrinsicBounds(0, selected ? info.getDrawableSelectedId() : info.getDrawableNormalId(), 0, 0);
//        tab.setTextColor(selected ? textSelectedColor : textNormalColor);
    }


    public List<TabInfo> getHomeTabInfoList() {
        List<TabInfo> homeTabInfoList = new ArrayList<>();
        homeTabInfoList.add(new TabInfo(
                R.drawable.icon_tab_home,
                R.drawable.icon_tab_home_selected));
        homeTabInfoList.add(new TabInfo(
                R.drawable.icon_tab_card,
                R.drawable.icon_tab_card_selected));
        homeTabInfoList.add(new TabInfo(
                R.drawable.icon_tab_coupon,
                R.drawable.icon_tab_coupon_selected));
        homeTabInfoList.add(new TabInfo(
                R.drawable.icon_tab_me,
                R.drawable.icon_tab_me_selected));
        return homeTabInfoList;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i != currentIndex) {
                    setTab(i);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    class TabInfo {
        private int drawableNormalId;
        private int drawableSelectedId;

        public TabInfo(int drawableNormalId, int drawableSelectedId) {
            this.drawableNormalId = drawableNormalId;
            this.drawableSelectedId = drawableSelectedId;
        }

        public int getDrawableNormalId() {
            return drawableNormalId;
        }

        public int getDrawableSelectedId() {
            return drawableSelectedId;
        }
    }

    interface OnTabClickListener {

        /***
         * @param view            被点击的view
         * @param currentPosition 当前位置
         * @param lastPosition    上一次位置
         */
        void onTabClick(View view, int currentPosition, int lastPosition);
    }
}