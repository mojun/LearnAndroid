package com.kimoworks.learnandroid;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by test on 16/8/24.
 */
public class ScreenTool {

    public static int mScreenWidth;
    public static int mScreenHeight;
    public static float mScreenDensity;
    public static float mScreenPPI;
    public static float mScreenInch;

    public static void init(Context context) {

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mScreenWidth = getScreenWidth(windowManager);
        mScreenHeight = getScreenHeight(windowManager);
        mScreenDensity = getScreenDensity(windowManager);
        mScreenPPI = getScreenPPI(windowManager);
        mScreenInch = getScreenInch();

        Log.v("ScreenTool", "mScreenWidth=" + mScreenWidth);
        Log.v("ScreenTool", "mScreenHeight=" + mScreenHeight);
        Log.v("ScreenTool", "mScreenDensity=" + mScreenDensity);
        Log.v("ScreenTool", "mScreenPPI=" + mScreenPPI);
        Log.v("ScreenTool", "mScreenInch=" + mScreenInch);
    }

    public static int getScreenWidth(WindowManager windowManager) {
        return getDisplayMetrics(windowManager).widthPixels;
    }

    public static int getScreenHeight(WindowManager windowManager) {
        return getDisplayMetrics(windowManager).heightPixels;
    }

    public static float getScreenDensity(WindowManager windowManager) {
        return getDisplayMetrics(windowManager).density;
    }

    public static float getScreenPPI(WindowManager windowManager) {
        return getDisplayMetrics(windowManager).densityDpi;
    }

    public static float getScreenInch() {
        return (float) Math.sqrt(Math.pow(mScreenHeight, 2) + Math.pow(mScreenWidth, 2)) / mScreenPPI;
    }

    private static DisplayMetrics getDisplayMetrics(WindowManager windowManager) {
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

}
