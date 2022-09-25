package com.whoami28.mrviperx;

import android.app.Activity;
import android.content.Context;

public class Main {

    //Load lib
    static {
        // When you change the lib name, change also on Android.mk file
        // Both must have same name
        System.loadLibrary("mrviperx");
    }

    private static native void CheckOverlayPermission(Context context);

    public static void StartWithoutPermission(Context context) {
        CrashHandler.init(context, true);
        if (context instanceof Activity) {
            //Check if context is an Activity.
            Menu menu = new Menu(context);
            menu.SetWindowManagerActivity();
            menu.ShowMenu();
        } else {
            //Anything else, ask for permission
            CheckOverlayPermission(context);
        }
    }

    public static void Start(Context context) {
        CrashHandler.init(context, false);

        CheckOverlayPermission(context);
    }
}
