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

    public ScreensStack(String tag, Application application) {
        mTag = tag;
        mApplication = application;
    }

    public void printScreenNames() {
        mApplication.registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
    }

    private void postToast(Activity activity) {
        String activityName = activity.getClass().getSimpleName();
        Toast.makeText(mApplication, activityName, Toast.LENGTH_SHORT).show();
    }

    private void registerFragmentCallbacks(Activity activity) {
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        ((FragmentActivity) activity).getSupportFragmentManager()
                .registerFragmentLifecycleCallbacks(
                        new MyFragmentLifecycleCallbacks(mApplication, mTag), true);
    }

    private class MyActivityLifecycleCallbacks extends SimpleActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            registerFragmentCallbacks(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            postToast(activity);
            Log.d(mTag, "onActivityStarted activity " + activity);
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.e(mTag, "onActivityStopped activity " + activity);
        }
    }
}
