package com.example.iamgescale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_INFO = 1;
    TextView tVResult, tVResultLable;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnReq = findViewById(R.id.btnRequest);
        Button btnEnd = findViewById(R.id.btnEnd);
        EditText editText = findViewById(R.id.editTextID);
        tVResultLable = findViewById(R.id.tVResultLabel);
        tVResult = findViewById(R.id.tVReult);
        btnReq.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                str = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
                intent.putExtra("id", str);
                startActivityForResult(intent, REQUEST_INFO);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode == REQUEST_INFO) && (resultCode == RESULT_OK)) {
            tVResultLable.setText("전송\n정보\n출력");
            str = "아이디: " + str;
            str = str + "\n이름: " + data.getStringExtra("name");
            str = str + "\n나이: " + data.getStringExtra("age");
            str = str + "\n성별: " + data.getStringExtra("sex");
            str = str + "\n자격증: " + data.getStringExtra("license");
            tVResult.setText(str);

        }
    }
}