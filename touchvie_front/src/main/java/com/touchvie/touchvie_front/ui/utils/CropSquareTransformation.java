package com.touchvie.touchvie_front.ui.utils;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

public class CropSquareTransformation implements Transformation {

    public Bitmap transform(Bitmap source, int anchor_x, int anchor_y, int targetWidth, int targetHeight) {

        int inWidth =source.getWidth();  //ancho imagen
        int inHeight =source.getHeight();  //alto imagen
        int drawY = 0;
        int drawX = 0;
        int drawHeight = 0;
        int drawWidth = 0;


        float widthRatio =
                targetWidth != 0 ? targetWidth / (float) inWidth : targetHeight / (float) inHeight;
        float heightRatio =
                targetHeight != 0 ? targetHeight / (float) inHeight : targetWidth / (float) inWidth;
        float scaleX, scaleY;
        if (widthRatio > heightRatio) {
            int newSize = (int) Math.ceil(inHeight * (heightRatio / widthRatio));
            drawY = (inHeight - newSize) * anchor_y / 100;
            drawHeight = newSize;
            scaleX = widthRatio;
            scaleY = targetHeight / (float) drawHeight;
        } else if (widthRatio < heightRatio) {
            int newSize = (int) Math.ceil(inWidth * (widthRatio / heightRatio));
            drawX = (inWidth - newSize) * anchor_x / 100;
            drawWidth = newSize;
            scaleX = targetWidth / (float) drawWidth;
            scaleY = heightRatio;
        } else {
            drawX = 0;
            drawWidth = inWidth;
            scaleX = scaleY = heightRatio;
        }
       /* if (shouldResize(onlyScaleDown, inWidth, inHeight, targetWidth, targetHeight)) {
            matrix.preScale(scaleX, scaleY);
        }*/

        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap result = Bitmap.createBitmap(source, x, y, size, size);
        if (result != source) {
            source.recycle();
        }
        return result;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        return null;
    }

    @Override
    public String key() { return "square()"; }
}
