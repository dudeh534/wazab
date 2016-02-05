package com.ourincheon.wazap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RecruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit);

        TextView nickname = (TextView) findViewById(R.id.leaderTxt);
        Intent intent = getIntent();
        String nick = (String)intent.getSerializableExtra("Nickname");
        nickname.setText(nick);

    }
}
