package com.egecius.mylibrary;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class ScreensStack {

    private String mTag;

    public ScreensStack(String tag) {
        mTag = tag;
    }

    public void printScreenNames(Application application) {
        application.registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
    }

    private class MyActivityLifecycleCallbacks extends SimpleActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            registerFragmentCallbacks(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.d(mTag, "onActivityStarted activity " + activity);
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.e(mTag, "onActivityStopped activity " + activity);
        }
    }

    private void registerFragmentCallbacks(Activity activity) {
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        ((FragmentActivity) activity).getSupportFragmentManager()
                .registerFragmentLifecycleCallbacks(new MyFragmentLifecycleCallbacks(mTag), true);
    }
}
