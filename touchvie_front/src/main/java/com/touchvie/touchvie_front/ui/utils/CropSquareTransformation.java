package com.touchvie.touchvie_front.ui.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.squareup.picasso.Transformation;

public class CropSquareTransformation implements Transformation {

    private int targetWidth;
    private int targetHeight;
    private int anchor_x;
    private int anchor_y;

    /**
     * Constructor
     * @param targetWidth: the width of de container (imageView)
     * @param targetHeight: the height of de container (imageView)
     * @param anchor_x: x coor of anchor
     * @param anchor_y: y coor of anchor
     */
    public CropSquareTransformation(int targetWidth, int targetHeight, int anchor_x, int anchor_y) {
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        this.anchor_x = anchor_x;
        this.anchor_y = anchor_y;
    }

    /**
<<<<<<< HEAD
     * Override tranform method to set the image anchors
=======
     * Override transform method to set the image anchors
>>>>>>> develop
     * @param source: bitmap
     * @return
     */
    @Override
    public Bitmap transform(Bitmap source) {
        int inWidth =source.getWidth();  //image width
        int inHeight =source.getHeight();  //image height
        int drawY = 0;
        int drawX = 0;
        int drawHeight = inHeight;
        int drawWidth = inWidth;

        Matrix matrix = new Matrix();


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
//        if (shouldResize(onlyScaleDown, inWidth, inHeight, targetWidth, targetHeight)) {
        matrix.preScale(scaleX, scaleY);
//        }

        Bitmap newResult =
                Bitmap.createBitmap(source, drawX, drawY, drawWidth, drawHeight, matrix, true);

        if (newResult != source) {
            source.recycle();
            source = newResult;
        }

        return source;

    }

    @Override
    public String key() { return "square()"; }
}
