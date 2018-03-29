package org.techtown.samplecallintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText); // 뷰 객체 참조

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString(); //editText의 입력된 데이터 확인
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data)); // 전화걸기 화면을 보여줄 인텐트 객체 생성
                startActivity(intent);  // 액티비티 띄우기
            }
        });
    }
}
