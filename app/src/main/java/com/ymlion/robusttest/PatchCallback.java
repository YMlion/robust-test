package com.ymlion.robusttest;

import android.util.Log;
import com.meituan.robust.Patch;
import com.meituan.robust.RobustCallBack;
import java.util.List;

/**
 * Created by YMlion on 2018/9/10.
 */
public class PatchCallback implements RobustCallBack {
    private static final String TAG = "PatchCallback";

    @Override public void onPatchListFetched(boolean result, boolean isNet, List<Patch> patches) {
        Log.d(TAG, "onPatchListFetched: " + result);
    }

    @Override public void onPatchFetched(boolean result, boolean isNet, Patch patch) {
        Log.d(TAG, "onPatchFetched: " + result + ", " + patch.getLocalPath());
    }

    @Override public void onPatchApplied(boolean result, Patch patch) {
        Log.d(TAG, "onPatchApplied: " + result);
    }

    @Override public void logNotify(String log, String where) {
        Log.d(TAG, "logNotify: " + log);
    }

    @Override public void exceptionNotify(Throwable throwable, String where) {
        Log.d(TAG, "exceptionNotify: " + throwable.getMessage());
    }
}
