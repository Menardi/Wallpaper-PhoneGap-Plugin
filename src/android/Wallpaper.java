package com.syncostyle.plugins.wallpaper;

import java.io.InputStream;
import java.net.URL;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import android.app.WallpaperManager;
import android.os.Build;


public class Wallpaper extends CordovaPlugin
{
    public static final String SET_WALLPAPER = "setwallpaper";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            JSONObject arg_object = args.getJSONObject(0);

            if (SET_WALLPAPER.equals(action)) {
                String path = arg_object.getString("imagePath");

                WallpaperManager wallpaperManager = WallpaperManager.getInstance(this.cordova.getActivity().getApplicationContext());

                InputStream ins;

                if(path.startsWith("file:///android_asset/")) {
                    String relativePath = path.replace("file:///android_asset/", "");
                    ins = this.cordova.getActivity().getApplicationContext().getAssets().open(relativePath);
                } else {
                    ins = new URL(path).openStream();
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    wallpaperManager.setStream(ins, null, false, WallpaperManager.FLAG_SYSTEM | WallpaperManager.FLAG_LOCK);
                } else {
                    wallpaperManager.setStream(ins);
                }

                callbackContext.success();
                return true;
            } else {
                callbackContext.error("Invalid action");
                return false;
            }
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}
