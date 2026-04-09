package kr.ac.kopo.android.linearlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. 전체 레이아웃 객체 생성
        // Context(this)를 전달하여 LinearLayout 객체 생성함
        LinearLayout linear = new LinearLayout(this);

        // 2. 레이아웃 파라미터 설정
        // 너비와 높이를 부모 요소에 꽉 차도록(MATCH_PARENT) 설정함
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        // 3. 레이아웃 속성 설정
        // 수직 방향 정렬 및 배경색 지정함
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setBackgroundColor(Color.MAGENTA);

        // 4. 버튼 객체 생성 및 설정
        Button btn = new Button(this);
        btn.setText("java 코드로 작성한 버튼");
        btn.setBackgroundColor(Color.BLUE);

        // 5. 버튼을 레이아웃에 추가함
        linear.addView(btn);

        // 6. 버튼 클릭 이벤트 리스너 정의
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 토스트 메시지 출력함
                Toast.makeText(getApplicationContext(), "java 코드로 작성한 버튼이 클릭되었음", Toast.LENGTH_SHORT).show();
            }
        });

        // 7. 설정한 레이아웃을 화면에 표시함
        setContentView(linear, params);
    }
}