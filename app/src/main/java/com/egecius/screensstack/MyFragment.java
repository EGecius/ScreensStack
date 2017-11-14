package com.egecius.screensstack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class MyFragment extends Fragment {

     public static MyFragment newInstance() {
      	return new MyFragment();
      }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
