package torrent.tab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_tablayout)
    public void gotoTabLayoutTabActivity(){
        TabLayoutTabActivity.start(this);
    }

    @OnClick(R.id.btn_tabhost)
    public void gotoFragmentTabHostActivity(){
        FragmentTabHostActivity.start(this);
    }

    @OnClick(R.id.btn_radiogroup)
    public void gotoRadioGroupTabActivity(){
        RadioGroupTabActivity.start(this);
    }
    @OnClick(R.id.btn_navigation)
    public void gotoBottomNavigationTabActivity(){
        BottomNavigationTabActivity.start(this);
    }
    @OnClick(R.id.btn_coustom)
    public void gotoCustomTabActivity(){
        CustomTabActivity.start(this);
    }

}
