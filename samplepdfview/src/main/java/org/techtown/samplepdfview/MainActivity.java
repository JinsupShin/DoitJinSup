package org.techtown.samplepdfview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        String filename = editText.getText().toString();   // 입력상자에 입력된 파일명 확인
        if(filename.length() > 0){
            openPDF(filename.trim());      // openPDF 메소드 호출
        }else{
            Toast.makeText(getApplicationContext(), "PDF 파일명을 입력하세요",Toast.LENGTH_LONG).show();
        }
    }

    public void openPDF(String filename){
        String sdcardFolder = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filepath = sdcardFolder + File.separator + filename;
        File file = new File(filepath);

        if(file.exists()){
            Uri uri = Uri.fromFile(file);        //Uri 객체로 생성

            Intent intent = new Intent(Intent.ACTION_VIEW);  // ACTION_VIEW 액션을 가지는 인텐트 생성
            intent.setDataAndType(uri, "application/pdf");  // Uri 객체와 MIME 타입 지정

            try{
                startActivity(intent);  // 액티비티 띄우기
            }catch (ActivityNotFoundException ex){
                Toast.makeText(this, "PDF 파일을 보기 위한 뷰어 앱이 없습니다."
                , Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "PDF 파일이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
