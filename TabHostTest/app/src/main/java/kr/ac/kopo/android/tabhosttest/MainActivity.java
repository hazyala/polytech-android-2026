package kr.ac.kopo.android.tabhosttest;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TabHost 객체 생성 및 초기화
        TabHost tabHost = getTabHost();

        // 강아지 탭 설정
        TabHost.TabSpec specDog = tabHost.newTabSpec("dog").setIndicator("강아지");
        specDog.setContent(R.id.tabDog);
        tabHost.addTab(specDog);

        // 고양이 탭 설정
        TabHost.TabSpec specCat = tabHost.newTabSpec("cat").setIndicator("고양이");
        specCat.setContent(R.id.tabCat);
        tabHost.addTab(specCat);

        // 토끼 탭 설정
        TabHost.TabSpec specRabbit = tabHost.newTabSpec("rabbit").setIndicator("토끼");
        specRabbit.setContent(R.id.tabRabbit);
        tabHost.addTab(specRabbit);

        // 첫 번째 탭을 기본으로 설정
        tabHost.setCurrentTab(0);
    }
}