package com.egecius.mylibrary;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

public class ScreensStack {

    private final String mTag;
    private final Application mApplication;
    private final boolean mPrintLongNames;

    public ScreensStack(String tag, Application application, boolean printLongNames) {
        mTag = tag;
        mApplication = application;
        mPrintLongNames = printLongNames;
    }

    public void printScreenNames() {
        mApplication.registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
    }

    private void postToast(Activity activity) {
        String activityName = getName(activity);
        Toast.makeText(mApplication, activityName, Toast.LENGTH_SHORT).show();
    }

    private String getName(Activity activity) {
        if (mPrintLongNames) {
            return activity.toString();
        }
        return activity.getClass().getSimpleName();
    }

    private void registerFragmentCallbacks(Activity activity) {
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        ((FragmentActivity) activity).getSupportFragmentManager()
                .registerFragmentLifecycleCallbacks(
                        new MyFragmentLifecycleCallbacks(mApplication, mTag, mPrintLongNames), true);
    }

    private class MyActivityLifecycleCallbacks extends SimpleActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            registerFragmentCallbacks(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            postToast(activity);
            Log.d(mTag, "onActivityStarted " + getName(activity));
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.e(mTag, "onActivityStopped " + getName(activity));
        }
    }
}
