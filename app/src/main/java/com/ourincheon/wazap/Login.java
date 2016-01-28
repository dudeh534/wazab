package com.ourincheon.wazap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Youngdo on 2016-01-19.
 */
public class Login extends Activity {
    SharedPreferences setting;
    SharedPreferences.Editor editor;
    EditText id, passwd;
    Button Login, signup;
    CheckBox AutoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        id = (EditText) findViewById(R.id.editText);
        passwd = (EditText) findViewById(R.id.editText2);
        Login = (Button) findViewById(R.id.button);
        signup = (Button) findViewById(R.id.button2);
        AutoLogin = (CheckBox) findViewById(R.id.checkBox);
        setting = getSharedPreferences("setting", 0);
        editor= setting.edit();

        if(!setting.getString("ID", "").isEmpty()){
            id.setText(setting.getString("ID", ""));
            passwd.setText(setting.getString("PW", ""));
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = id.getText().toString();
                String PW = passwd.getText().toString();
                if(ID.equals("123")&&PW.equals("123")) {
                    if(AutoLogin.isChecked()){
                        editor.putString("ID", ID);
                        editor.putString("PW", PW);
                        editor.commit();
                    }
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(Login.this, "로그인 정보가 틀립니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(Login.this, SignUpActivity.class);
                startActivity(signup);
            }
        });
    }
}
