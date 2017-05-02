package torrent.tab.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import torrent.tab.R;

/**
 * Author:  Wang Tao
 * Email:   6190171759@qq.com | torrent.wang@gmail.com
 * Date:    2017/5/2.
 * Description:
 */

public class MeFragment extends Fragment {

    private String mText;

    public static HomeFragment newInstance(String from) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString("text");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, null);
        TextView content = (TextView) view.findViewById(R.id.fragment_content);
        content.setText(mText);
        return view;
    }

}
