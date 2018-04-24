package com.egecius.mylibrary;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Toast;

class MyFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

    private final Application mApplication;
    private final String mTag;
    private boolean mPrintLongNames;

    MyFragmentLifecycleCallbacks(Application application, String tag, boolean printLongNames) {
        mApplication = application;
        mTag = tag;
        mPrintLongNames = printLongNames;
    }

    @Override
    public void onFragmentStarted(FragmentManager fm, Fragment fragment) {
        showToast(fragment);
        Log.i(mTag, "onFragmentStarted " + getName(fragment));
    }

    private void showToast(Fragment fragment) {
        String fragmentName = fragment.getClass().getSimpleName();
        Toast.makeText(mApplication, fragmentName, Toast.LENGTH_SHORT).show();
    }

    private String getName(Object object) {
        if (mPrintLongNames) {
            return object.toString();
        }
        return object.getClass().getSimpleName();
    }

    @Override
    public void onFragmentStopped(FragmentManager fm, Fragment fragment) {
        Log.w(mTag, "onFragmentStopped " + getName(fragment));
    }
}
