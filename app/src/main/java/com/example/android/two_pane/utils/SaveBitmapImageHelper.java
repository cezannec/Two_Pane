package com.example.android.two_pane.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class SaveBitmapImageHelper {

    public static Bitmap getBitmap(Resources resources, int drawableResourceId) {
        return BitmapFactory.decodeResource(resources,
                drawableResourceId);
    }

    public static Bitmap combineDrawables(Resources resources, int head, int body, int legs) {
        Bitmap headBitmap = getBitmap(resources, head);
        Bitmap bodyBitmap = getBitmap(resources, body);
        Bitmap legsBitmap = getBitmap(resources, legs);

        int combinedHeight = headBitmap.getHeight() + bodyBitmap.getHeight() + legsBitmap.getHeight();
        int width = Math.max(headBitmap.getWidth(), Math.max(bodyBitmap.getWidth(), legsBitmap.getWidth()));

        // Create Bitmap of specified size, width, and color representation
        Bitmap finalImage = Bitmap.createBitmap(width, combinedHeight, Bitmap.Config.ARGB_8888);

        // Create new canvas to draw all three Android-Me pieces
        // Draw each at the correct height offset
        Canvas combinedImage = new Canvas(finalImage);
        combinedImage.drawBitmap(headBitmap, 0f, 0f, null);
        combinedImage.drawBitmap(bodyBitmap, 0f, headBitmap.getHeight(), null);
        combinedImage.drawBitmap(legsBitmap, 0f, headBitmap.getHeight() + bodyBitmap.getHeight(), null);

        return finalImage;
    }
}
