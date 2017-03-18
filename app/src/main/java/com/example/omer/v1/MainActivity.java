package com.example.omer.v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText mMsg;
    TextView mChatContent;
    Button mSend;
    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMsg = (EditText) findViewById(R.id.msgContainer);
        mSend = (Button) findViewById(R.id.sendMsg);
        mChatContent = (TextView) findViewById(R.id.chat);
        mSend.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                addLine();
            }
        });
        scroll = (ScrollView) findViewById(R.id.ScrollView01);
    }

    private void addLine(){
        String content = mChatContent.getText().toString();
        content += '\n' + mMsg.getText().toString();
        if(content.split("\n").length > 10){
            content = TextUtils.join("\n",Arrays.copyOfRange(content.split("\n"), 1, content.split("\n").length));
        }
        mChatContent.setText(content);
        mMsg.setText("");
    }
}
