package com.ourincheon.wazap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ourincheon.wazap.KaKao.infoKaKao;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Hsue.
 */

public class RecruitActivity extends AppCompatActivity {

    infoKaKao kakao;
    String thumbnail;
    ImageView profileImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit);

        TextView nickname = (TextView) findViewById(R.id.leaderTxt);
        Intent intent = getIntent();
        kakao = (infoKaKao) intent.getSerializableExtra("KakaoInfo");
        nickname.setText(kakao.getName());


        profileImg = (ImageView) findViewById(R.id.Pro);
        thumbnail = kakao.getThumbnail();
        ThumbnailImage thumb = new ThumbnailImage();
        thumb.execute();
    }

    /**
     * **분리할방법 고민해보기*****
     */
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
}