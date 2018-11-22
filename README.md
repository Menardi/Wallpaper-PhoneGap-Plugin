# Wallpaper-PhoneGap-Plugin

Set wallpapers on Android. Forked from https://github.com/PurpleMADcanada/Wallpaper-PhoneGap-Plugin.

## Installation

```
cordova plugin add https://github.com/Menardi/Wallpaper-PhoneGap-Plugin
```

## Usage
The plugin allows for the setting of the wallpaper on Android, using the `setImage` function.

```
window.wallpaper.setImage(path, successCb, errorCb);
```

*path*: The absolute path to the image. Can be local or remote. If local, ensure it begins with `file:///android_asset/www/`.
*successCb*: Called upon successfully setting the wallpaper
*errorCb*: Called with an error object as the argument if setting the wallpaper fails