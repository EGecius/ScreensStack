package com.egecius.mylibrary;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class ScreensStack {

    private Application.ActivityLifecycleCallbacks mCallback = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            registerFragmentCallbacks(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.i("Eg:ScreensStack:26", "onActivityStarted activity " + activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.w("Eg:ScreensStack:41", "onActivityStopped activity " + activity);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    private FragmentManager.FragmentLifecycleCallbacks
            mFragmentLifecycleCallbacks = new MyFragmentLifecycleCallbacks();

    public void init(Application application) {
        application.registerActivityLifecycleCallbacks(
                mCallback);
    }

    private void registerFragmentCallbacks(Activity activity) {
        if (!(activity instanceof FragmentActivity)) {
            return;
        }

        ((FragmentActivity) activity).getSupportFragmentManager()
                .registerFragmentLifecycleCallbacks(
                        mFragmentLifecycleCallbacks, false);
    }

}
