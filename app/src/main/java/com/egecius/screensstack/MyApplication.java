package com.egecius.screensstack;

import android.app.Application;

import com.egecius.mylibrary.ScreensStack;

public class MyApplication extends Application {

    private ScreensStack mScreensStack;

    @Override
    public void onCreate() {
        super.onCreate();
        initScreensStack();
    }

    private void initScreensStack() {
        mScreensStack = new ScreensStack(this);
        mScreensStack.printScreenNames();
    }
}
