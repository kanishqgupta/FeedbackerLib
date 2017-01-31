package com.kanishq.feedbacker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class feedbackerActivity extends AppCompatActivity {

    EditText editextTo, edittextSubject, edittextMessage;
    Button button1;
    String TO, SUBJECT, MESSAGE ;
    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedbacker);

        edittextSubject = (EditText)findViewById(R.id.editText2);
        edittextMessage = (EditText)findViewById(R.id.editText3);

        button1 = (Button)findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                feedbacker fd = new feedbacker();
                fd.deviceInf(getApplicationContext());


            }
        });

    }

    public void GetData(){

        TO = editextTo.getText().toString() ;
        SUBJECT = edittextSubject.getText().toString();
        MESSAGE = edittextMessage.getText().toString();

    }

}