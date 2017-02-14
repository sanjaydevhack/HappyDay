package com.independentdev.ink.helper;

import android.os.Build;

/**
 * Created by sanjayjith.madhavan on 2/14/2017.
 */

public class CommonMethods {

    public static boolean isAboveLolipop() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP;
    }
}
