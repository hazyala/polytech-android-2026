package kr.ac.kopo.android.helloandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RadioGroup rg;
    RadioButton rba, rbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);

        btn.setOnClickListener(btnListener);
        rg.setOnCheckedChangeListener(rgListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast toast = Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT);
            toast.show();
        }
    };

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String msg = "";
            if (checkedId == R.id.rba) {
                msg = "알림 수신";
            } else if (checkedId == R.id.rbc) {
                msg = "알림 거부";
            }
            Toast toast = Toast.makeText(MainActivity.this, msg + "를 선택하셨습니다.", Toast.LENGTH_SHORT);
            toast.show();
        }
    };
}