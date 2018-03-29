package org.techtown.sampleintent;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;  // final 상수 바꿀수 없음.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void  onButton1Clicked(View v){

        // 다른화면 띄운예제1
//        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//        startActivityForResult(intent, REQUEST_CODE_MENU);

        // 다른화면 띄운예제2
        // ComponentName 객체의 2개의 파라미터 는 각각 패키지이름 , 클래스 이름
        // 컴포넌트 이름을 지정할때 유의할점 : 대상 액티비티의 이름을 지정할때도 패키지 이름까지 함께 사용해야된다.
        Intent intent = new Intent();
        ComponentName name = new ComponentName("org.techtown.sampleintent"
        ,"org.techtown.sampleintent.MenuActivity");
        intent.setComponent(name);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(),
                    "onActivityResult 메소드 호출됨. 요청코드 : " + requestCode +
            ", 결과코드 : " + resultCode, Toast.LENGTH_LONG).show();

            if(resultCode == RESULT_OK){
                String name = data.getExtras().getString("name");
                Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name,
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
