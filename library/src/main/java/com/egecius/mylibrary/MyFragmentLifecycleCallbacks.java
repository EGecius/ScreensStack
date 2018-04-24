package com.egecius.mylibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

class MyFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

    private String mTag;

    MyFragmentLifecycleCallbacks(String tag) {
        mTag = tag;
    }

    @Override
    public void onFragmentStarted(FragmentManager fm, Fragment f) {
        Log.i(mTag, "onFragmentStarted f " + f);
    }

    @Override
    public void onFragmentStopped(FragmentManager fm, Fragment f) {
        Log.w(mTag, "onFragmentStopped f " + f);
    }
}
