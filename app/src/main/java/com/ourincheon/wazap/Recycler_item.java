package com.ourincheon.wazap;

/**
 * Created by Youngdo on 2016-01-19.
 */
public class Recycler_item {

    private String title;
    private String text;
    private String name;


    String getTitle(){
        return this.title;
    }

    String getText(){
        return this.text;
    }
    String getName(){
        return this.name;
    }

    Recycler_item(String title, String text, String name){
        this.title=title;
        this.text=text;
        this.name=name;
    }
}
