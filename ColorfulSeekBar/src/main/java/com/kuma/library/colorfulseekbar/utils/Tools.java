package com.kuma.library.colorfulseekbar.utils;

import android.content.res.ColorStateList;
import android.content.res.Resources;

public class Tools {

    public static ColorStateList getSimpleColorState(int color) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{color});
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }


}
