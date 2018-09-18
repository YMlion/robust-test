package com.ymlion.robusttest;

import android.content.Context;
import com.meituan.robust.Patch;
import com.meituan.robust.PatchManipulate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YMlion on 2018/9/10.
 */
public class PatchManipulateImpl extends PatchManipulate {
    @Override protected List<Patch> fetchPatchList(Context context) {
        Patch patch = new Patch();
        patch.setName("patch_file");
        patch.setTempPath(context.getExternalCacheDir().getAbsolutePath() + "/patch/patch");
        patch.setPatchesInfoImplClassFullName("com.ymlion.robusttest.patch.PatchesInfoImpl");
        List<Patch> patches = new ArrayList<>();
        patches.add(patch);
        return patches;
    }

    @Override protected boolean verifyPatch(Context context, Patch patch) {
        return true;
    }

    @Override protected boolean ensurePatchExist(Patch patch) {
        File patchFile = new File(patch.getTempPath());
        return patchFile.exists() && patchFile.length() > 0;
    }
}
