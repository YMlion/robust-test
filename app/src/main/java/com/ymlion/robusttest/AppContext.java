package com.ymlion.robusttest;

import android.app.Application;
import com.meituan.robust.PatchExecutor;

/**
 * Created by YMlion on 2018/9/10.
 */
public class AppContext extends Application {
    @Override public void onCreate() {
        super.onCreate();
        new PatchExecutor(this, new PatchManipulateImpl(), new PatchCallback()).start();
    }

    @Override public void onTerminate() {
        super.onTerminate();
    }
}
