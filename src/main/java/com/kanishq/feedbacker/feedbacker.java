package com.kanishq.feedbacker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.io.File;

/**
 * Created by gupta on 29-01-2017.
 */

public class feedbacker extends Activity {
    public static String e;




    public static void deviceInf(Context ctx) {

        String deviceInfo = "Device Info:";
        deviceInfo += "\n Android Version: " + Build.VERSION.RELEASE;
        deviceInfo += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        deviceInfo += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        deviceInfo += "\n Device: " + android.os.Build.DEVICE;

        deviceInfo += "\n Model (and Product): " + android.os.Build.MODEL + " (" + android.os.Build.PRODUCT + ")";
        deviceInfo += "\n Model manufacturer:" + Build.BRAND;
        deviceInfo += "\n Model Hardware:" +Build.HARDWARE;

        PackageInfo pinfo = null;
        try {
            pinfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }

        int versionNumber = pinfo.versionCode;
        String versionName = pinfo.versionName;

        deviceInfo +="\n App Version : " + versionName + versionNumber;
        deviceInfo += "\n Root Status:" +isRooted();

        String locale = ctx.getResources().getConfiguration().locale.getCountry();
        deviceInfo += "\n Country:" + locale;

        Intent email = new Intent(Intent.ACTION_SEND);

        String emailID = emailaddress();
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailID});
        email.putExtra(Intent.EXTRA_SUBJECT, ctx.getPackageName() + " Feedback /Bug Report");
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_TEXT, "\n\n\n" + deviceInfo);
        Intent new_intent = Intent.createChooser(email, "Email Via...");
        new_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(new_intent);

    }
    public static String emailaddress() {
        return e;
    }


    public static boolean isRooted() {

        // get from build info
        String buildTags = android.os.Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }

        // check if /system/app/Superuser.apk is present
        try {
            File file = new File("/system/app/Superuser.apk");
            if (file.exists()) {
                return true;
            }
        } catch (Exception e1) {
            // ignore


        }

        // try executing commands
        return canExecuteCommand("/system/xbin/which su")
                || canExecuteCommand("/system/bin/which su") || canExecuteCommand("which su");
    }

    // executes a command on the system
    private static boolean canExecuteCommand(String command) {
        boolean executedSuccesfully;
        try {
            Runtime.getRuntime().exec(command);
            executedSuccesfully = true;
        } catch (Exception e) {
            executedSuccesfully = false;
        }

        return executedSuccesfully;
    }




}



