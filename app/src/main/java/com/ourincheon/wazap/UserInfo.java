package com.ourincheon.wazap;

/**
 * Created by hsue
 */
public class UserInfo {
    String access_token;
    String kakao_id;
    String username;
    String password;
    String school;
    int age;
    String major;
    String locate;
    String introduce;
    String exp;

    public UserInfo(String access_token, String kakao_id, String username, String password, String school, int age, String major,String locate, String introduce, String exp)
    {
        this.access_token = access_token;
        this.kakao_id = kakao_id;
        this.username = username;
        this.password = password;
        this.school = school;
        this.age = age;
        this.major = major;
        this.locate = locate;
        this.introduce = introduce;
        this.exp = exp;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getKakao_id() {
        return kakao_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSchool() {
        return school;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public String getLocate() {
        return locate;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getExp() {
        return exp;
    }
}
