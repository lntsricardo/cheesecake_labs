package com.cheesecake.util;

import android.content.Context;

/**
 * Created by Ricardo Freire on 4/1/15.
 */
public class ImageUtil {

    public static int getImageResouce(Context context, String imageName){
        String name = imageName.replaceAll("[\\s\\-]", "").toLowerCase().trim();
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

}
