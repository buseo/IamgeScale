package com.example.iamgescale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent intent = getIntent();
        String str = intent.getStringExtra("id");
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAge = findViewById(R.id.editTextAge);
        RadioButton radioMale = findViewById(R.id.radioMale);
        RadioButton radioFemale = findViewById(R.id.radioFemale);
        CheckBox cBInfo = findViewById(R.id.cBInfo);
        CheckBox cBAI = findViewById(R.id.cBAI);
        CheckBox cBSecurity = findViewById(R.id.cBSecurity);

        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("age",editTextAge.getText().toString());
                if(radioFemale.isChecked())
                    intent.putExtra("sex","여자");
                else
                    intent.putExtra("sex","남자");
                String strLincense ="";
                if(cBInfo.isChecked())
                    strLincense = "\n 정보처리기사";
                if(cBAI.isChecked())
                    strLincense += "\n 인공지능데이터전문가";
                if(cBSecurity.isChecked())
                    strLincense += "\n 정보보안기사";
                intent.putExtra("license", strLincense);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }

    }
