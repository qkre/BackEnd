package com.example.demo2.singleton;

public class Settings {

    // 필드에 내 자신이 자료형으로 들어와 있다.
    private  static  Settings settings = null;

    //
    public static Settings getSettings() {
        if(settings == null){
            settings = new Settings();
        }

        return settings;
    }

    private int fontSize = 10;

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
