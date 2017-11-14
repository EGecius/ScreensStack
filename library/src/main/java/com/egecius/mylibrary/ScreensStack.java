package com.egecius.mylibrary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

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
            Log.i("Eg:ScreensStack:41", "onActivityStopped activity " + activity);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    private FragmentManager.FragmentLifecycleCallbacks
            mFragmentLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() {
                @Override
                public void onFragmentPreAttached(FragmentManager fm, Fragment f,
                        Context context) {
                    super.onFragmentPreAttached(fm, f, context);
                }

                @Override
                public void onFragmentAttached(FragmentManager fm, Fragment f,
                        Context context) {
                    super.onFragmentAttached(fm, f, context);
                }

                @Override
                public void onFragmentPreCreated(FragmentManager fm, Fragment f,
                        Bundle savedInstanceState) {
                    super.onFragmentPreCreated(fm, f, savedInstanceState);
                }

                @Override
                public void onFragmentCreated(FragmentManager fm, Fragment f,
                        Bundle savedInstanceState) {
                    super.onFragmentCreated(fm, f, savedInstanceState);
                }

                @Override
                public void onFragmentActivityCreated(FragmentManager fm, Fragment f,
                        Bundle savedInstanceState) {
                    super.onFragmentActivityCreated(fm, f, savedInstanceState);
                }

                @Override
                public void onFragmentViewCreated(FragmentManager fm, Fragment f,
                        View v,
                        Bundle savedInstanceState) {
                    super.onFragmentViewCreated(fm, f, v, savedInstanceState);
                }

                @Override
                public void onFragmentStarted(FragmentManager fm, Fragment f) {
                    super.onFragmentStarted(fm, f);
                    Log.i("Eg:ScreensStack:103", "onFragmentStarted f " + f);
                }

                @Override
                public void onFragmentResumed(FragmentManager fm, Fragment f) {
                    super.onFragmentResumed(fm, f);
                }

                @Override
                public void onFragmentPaused(FragmentManager fm, Fragment f) {
                    super.onFragmentPaused(fm, f);
                }

                @Override
                public void onFragmentStopped(FragmentManager fm, Fragment f) {
                    super.onFragmentStopped(fm, f);
                    Log.i("Eg:ScreensStack:120", "onFragmentStopped f " + f);
                }

                @Override
                public void onFragmentSaveInstanceState(FragmentManager fm, Fragment f,
                        Bundle outState) {
                    super.onFragmentSaveInstanceState(fm, f, outState);
                }

                @Override
                public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
                    super.onFragmentViewDestroyed(fm, f);
                }

                @Override
                public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
                    super.onFragmentDestroyed(fm, f);
                }

                @Override
                public void onFragmentDetached(FragmentManager fm, Fragment f) {
                    super.onFragmentDetached(fm, f);
                }
            };

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
