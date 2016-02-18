package com.ourincheon.wazap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Hsue.
 */

public class MypageActivity extends AppCompatActivity {

    private EditText eName, eMajor, eUniv, eLoc, eKakao, eIntro, eExp;
    String access_token, kakao_id, username, password, school, major, locate, introduce, exp;
    int age;
    UserInfo userInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        eName = (EditText) findViewById(R.id.eName);
        eMajor = (EditText) findViewById(R.id.eMajor);
        eUniv = (EditText) findViewById(R.id.eUniv);
        eLoc = (EditText) findViewById(R.id.eLoc);
        eKakao = (EditText) findViewById(R.id.eKakao);
        eIntro = (EditText) findViewById(R.id.eIntro);
        eExp = (EditText) findViewById(R.id.eExp);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mypage, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            username = eName.getText().toString();
            major = eMajor.getText().toString();
            school = eUniv.getText().toString();
            locate = eLoc.getText().toString();
            kakao_id = eKakao.getText().toString();
            introduce = eIntro.getText().toString();
            exp = eExp.getText().toString();

            userInfo = new UserInfo("3jkl35al3kljkldsfjlas83kln", kakao_id, username, "1234", school, 94, major, locate, introduce, exp);

            postInfo(userInfo);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    void postInfo(UserInfo userInfo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WazapService service = retrofit.create(WazapService.class);

        Call<regMsg> call = service.createInfo(userInfo);
        call.enqueue(new Callback<regMsg>() {
            @Override
            public void onResponse(Response<regMsg> response) {
                if (response.isSuccess() && response.body() != null) {
                    Log.d("SUCCESS", response.message());
                    //user = response.body();
                } else if (response.isSuccess()) {
                    Log.d("Response Body isNull", response.message());
                } else {
                    Log.d("Response Error Body", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

}
