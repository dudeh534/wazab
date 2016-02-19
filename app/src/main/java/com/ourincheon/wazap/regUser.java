package com.ourincheon.wazap;

/**
 * Created by hsue on 16. 2. 19.
 */
public class regUser
{
    boolean result;
    String msg;
   // JSONData data;

    public boolean isResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

   /* public JSONData getData()
    {
        return data;
    }
*/
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