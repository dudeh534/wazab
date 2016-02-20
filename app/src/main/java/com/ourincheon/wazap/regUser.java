package com.ourincheon.wazap;

import org.json.JSONObject;

/**
 * Created by hsue on 16. 2. 19.
 */
public class regUser
{
    boolean result;
    String msg;
    JSONObject data;

    public boolean isResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

    public JSONObject getData()
    {
        return data;
    }

}

class JSONData{
    public String username;
    String major;
    String school;
    String locate;
    String kakao_id;
    String introduce;
    String exp;
    int age;


}