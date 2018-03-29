package org.techtown.sampleintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = (Button) findViewById(R.id.button);   // 버튼 객체 참조
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();                    // 인텐트 객체 생성하고 name값을
                intent.putExtra("name", "mike");   // 부가 데이터로 넣기
                setResult(RESULT_OK, intent);                    // 응답보내기 (전달할 파라미터)

                finish();  // 현재 액티비티 없애기
            }
        });
    }
}
