package kr.ac.kopo.android.actionbarfragmenttest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar.Tab tabDog, tabCat, tabRabbit;
    MyTabFragment[] myTabFragments = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            tabDog = bar.newTab().setText("강아지").setTabListener(this);
            bar.addTab(tabDog);

            tabCat = bar.newTab().setText("고양이").setTabListener(this);
            bar.addTab(tabCat);

            tabRabbit = bar.newTab().setText("토끼").setTabListener(this);
            bar.addTab(tabRabbit);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment selectedFragment;
        int pos = tab.getPosition();

        if (myTabFragments[pos] == null) {
            selectedFragment = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            selectedFragment.setArguments(data);
            myTabFragments[pos] = selectedFragment;
        } else {
            selectedFragment = myTabFragments[pos];
        }

        ft.replace(R.id.fragment_container, selectedFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    public static class MyTabFragment extends Fragment {
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                tabName = getArguments().getString("tabName");
            }
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            // 레이아웃 동적 생성
            LinearLayout linear = new LinearLayout(getActivity());
            linear.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            linear.setOrientation(LinearLayout.VERTICAL);

            if ("강아지".equals(tabName)) {
                linear.setBackgroundColor(Color.BLUE);
            } else if ("고양이".equals(tabName)) {
                linear.setBackgroundColor(Color.RED);
            } else if ("토끼".equals(tabName)) {
                linear.setBackgroundColor(Color.GREEN);
            }

            return linear;
        }
    }
}