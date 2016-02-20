package com.ourincheon.wazap;


import com.ourincheon.wazap.KaKao.infoKaKao;
import com.ourincheon.wazap.Retrofit.ContestInfo;
import com.ourincheon.wazap.Retrofit.UserInfo;
import com.ourincheon.wazap.Retrofit.regMsg;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WazapService {
    /*
    @GET("oauth/authorize?response_type=code")
    //client_id={app_key}&redirect_uri={redirect_uri}&
    Call<KaKaoReturn> getKakao(
            @Query("client_id") String app_key,
            @Query("redirect_uri") String redirect_uri);

    @GET("/kakao_oauth?")
    Call<ServerReturn> getAccess(
            @Query("code") String code);
            */
    @GET("/kakao_oauth?")
    Call<infoKaKao> getToken(
            @Query("nickname") String name,
            @Query("thumnail") String thumnail);


    // 사용자 정보 저장하기
    @POST("/users/reg")
    Call<regMsg> createInfo(
            @Body UserInfo userInfo);


    // 사용자 정보 받아오기
    @GET("users/{user_id}")
    Call<regUser> getUserInfo(
            @Path("user_id") String user_id
    );

    // 모집글 쓰기
    @POST("contests")
    Call<regMsg> createContests(
            @Body ContestInfo contestInfo
    );
}


