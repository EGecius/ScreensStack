package com.egecius.mylibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

class MyFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    @Override
    public void onFragmentStarted(FragmentManager fm, Fragment f) {
        Log.d("Eg:ScreeMyFragment..:10", "onFragmentStarted f " + f);
    }

    @Override
    public void onFragmentStopped(FragmentManager fm, Fragment f) {
        Log.e("Eg:ScreeMyFragment.:120", "onFragmentStopped f " + f);
    }
}
