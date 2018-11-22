var wallpaper =  {
    setImage: function(imagePath, successCallback, errorCallback) {
        cordova.exec(
            successCallback, 	// success callback function
            errorCallback, 		// error callback function
            'Wallpaper', 		// mapped to our native Java class called "Wallpaper"
            'setwallpaper', 	// with this action name
            [{                  // and this array of custom arguments to create our entry
                "imagePath": imagePath
            }]
        );
    }
};
module.exports = wallpaper;