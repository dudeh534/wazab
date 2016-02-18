package com.ourincheon.wazap;


import com.ourincheon.wazap.KaKao.infoKaKao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
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
}
