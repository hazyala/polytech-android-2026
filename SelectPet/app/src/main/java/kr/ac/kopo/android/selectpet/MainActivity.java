package kr.ac.kopo.android.selectpet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chkStart;
    RadioGroup rgPet;
    RadioButton rbCat, rbDog, rbHamster;
    Button btnSelect;
    ImageView imgPet;

    // LinearLayout과 FrameLayout으로 변경
    LinearLayout cardRadio;
    FrameLayout cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        chkStart = findViewById(R.id.chk_start);
        rgPet = findViewById(R.id.rg_pet);
        rbCat = findViewById(R.id.rb_cat);
        rbDog = findViewById(R.id.rb_dog);
        rbHamster = findViewById(R.id.rb_hamster);
        btnSelect = findViewById(R.id.btn_select);
        imgPet = findViewById(R.id.img_pet);

        cardRadio = findViewById(R.id.card_radio);
        cardView = findViewById(R.id.card_view);

        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cardRadio.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.VISIBLE);
                } else {
                    cardRadio.setVisibility(View.INVISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    rgPet.clearCheck();
                    imgPet.setImageResource(0);
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgPet.getCheckedRadioButtonId();

                if (selectedId == R.id.rb_cat) {
                    imgPet.setImageResource(R.drawable.cat);
                } else if (selectedId == R.id.rb_dog) {
                    imgPet.setImageResource(R.drawable.dog);
                } else if (selectedId == R.id.rb_hamster) {
                    imgPet.setImageResource(R.drawable.hamster);
                } else {
                    Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}