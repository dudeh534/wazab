package com.ourincheon.wazap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.ourincheon.wazap.Retrofit.UserInfo;
import com.ourincheon.wazap.Retrofit.regMsg;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hsue.
 */

public class MypageActivity extends AppCompatActivity {

    private EditText eName, eMajor, eUniv, eLoc, eKakao, eIntro, eExp;
    String access_token, kakao_id, username, password, school, major, locate, introduce, exp;
    int age;
    UserInfo userInfo;
    regMsg res;

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
            username = eName.getText().toString().trim();
            major = eMajor.getText().toString().trim();
            school = eUniv.getText().toString().trim();
            locate = eLoc.getText().toString().trim();
            kakao_id = eKakao.getText().toString();
            introduce = eIntro.getText().toString().trim();
            exp = eExp.getText().toString().trim();

            userInfo = new UserInfo("test", kakao_id, username, school, 94, major, locate, introduce, exp);

            postInfo(userInfo);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    void postInfo(UserInfo userInfo) {

        System.out.println(userInfo.getAccess_token());
        System.out.println(userInfo.getAge());
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://come.n.get.us.to")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WazapService service = retrofit.create(WazapService.class);

        Call<regMsg> call = service.createInfo(userInfo);
        call.enqueue(new Callback<regMsg>() {
            @Override
            public void onResponse(Call<regMsg> call, Response<regMsg> response) {
                if (response.isSuccess() && response.body() != null) {

                    res = response.body();
                    Log.d("SUCCESS", response.message());
                    Log.d("SUCCESS", res.getMsg());
                    //user = response.body();
                } else if (response.isSuccess()) {
                    Log.d("Response Body isNull", response.message());
                } else {
                    Log.d("Response Error Body", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<regMsg> call, Throwable t) {
                t.printStackTrace();
                Log.e("Error", t.getMessage());
            }
        });
    }

}
