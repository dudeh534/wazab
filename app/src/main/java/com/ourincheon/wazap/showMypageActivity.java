package com.ourincheon.wazap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Hsue.
 */
public class showMypageActivity extends AppCompatActivity {

    infoKaKao kakao;
    String thumbnail;
    ImageView profileImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_mypage);

        Intent intent = getIntent();
        kakao = (infoKaKao)intent.getSerializableExtra("KakaoInfo");

        TextView nickname = (TextView) findViewById(R.id.sName);
        nickname.setText(kakao.getName());

        profileImg = (ImageView)findViewById(R.id.sPro);
        thumbnail = kakao.getThumbnail();
        ThumbnailImage thumb = new ThumbnailImage();
        thumb.execute();
    }

    /*****분리할방법 고민해보기******/
    public class ThumbnailImage extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            // TODO Auto-generated method stub

            try {
                URL url = new URL(thumbnail);
                InputStream is = url.openConnection().getInputStream();
                Bitmap bitMap = BitmapFactory.decodeStream(is);
                return bitMap;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            profileImg.setImageBitmap(result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_mypage, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit) {
            Intent i = new Intent(showMypageActivity.this, MypageActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
