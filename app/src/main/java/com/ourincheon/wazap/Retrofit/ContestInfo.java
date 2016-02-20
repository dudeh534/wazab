package com.ourincheon.wazap.Retrofit;

/**
 * Created by sue on 2016-02-20.
 */
public class ContestInfo {
    String access_token, title, hosts, categories,period, cover,positions;
    Integer recruitment;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public void setRecruitment(Integer recruitment) {
        this.recruitment = recruitment;
    }
}
