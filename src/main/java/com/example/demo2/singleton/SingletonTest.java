package com.example.demo2.singleton;

import java.util.Set;

public class SingletonTest {

    public void test(){
        // 둘은 서로 같은 하나의 settings 객체를 가지고 있음.
        Settings settings1 = Settings.getSettings();
        Settings settings2 = Settings.getSettings();
    }
}
