package kr.ac.kopo.android.radiobuttontest;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. 사용할 변수들을 클래스 상단에 선언
    private RadioGroup rg;
    private RadioButton rbMale, rbFemale;
    private TextView textResult;

    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. XML의 ID와 자바 변수를 연결
        rg = findViewById(R.id.rg);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        textResult = findViewById(R.id.text_result);
        imgv = findViewById(R.id.imgv);

        // 3. 만들어둔 리스너 변수(listener)를 라디오 그룹에 연결
        rg.setOnCheckedChangeListener(listener);
    }

    // 4. 별도의 변수로 리스너 객체를 정의
    RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
            String result = "";
            int imgRes = 0;

            // 선택된 ID가 남성 버튼의 ID와 같다면
            if (checkedId == rbMale.getId()) {
                result = "남성";
                imgRes = R.drawable.male;
            }
            // 그렇지 않다면 (여성 버튼인 경우)
            else {
                result = "여성";
                imgRes = R.drawable.female;
            }

            // 결과 텍스트 뷰에 문구 설정
            textResult.setText(result + "을 선택함");
            imgv.setImageResource(imgRes);
        }
    };
}