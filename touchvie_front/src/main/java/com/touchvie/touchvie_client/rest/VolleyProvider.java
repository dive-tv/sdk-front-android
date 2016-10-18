package com.touchvie.touchvie_client.rest;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * VolleyProvider class manages the request queue for the REST services.
 */
public class VolleyProvider {

    private static VolleyProvider mInstance;
    private static RequestQueue mRequestQueue;
    private static Context mCtx;
    private ImageLoader mImageLoader;

    /**
     * VolleyProvider constructor.
     *
     * @param {Context} ctx. Context where the current Volley provider was created.
     */
    private VolleyProvider(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    /**
     * Get the instance of the created Volley provider. Create it if it does not exist.
     *
     * @param {Context} ctx. Context where the current Volley provider is created.
     * @returns {VolleyProvider} mInstance. The Volley provider instance.
     */
    public static synchronized VolleyProvider getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyProvider(context);
        }
        return mInstance;
    }

    /**
     * Get the REST services requests queue.
     *
     * @returns {RequestQueue} mRequestQueue. The request queue.
     */
    public static synchronized RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    /**
     * Add a request to the request queue.
     *
     * @param {Request<T>} req. Request to be added.
     */
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


    /**
     * Get the image loader of the Volley provider.
     *
     * @returns {ImageLoader} mImageLoader. The image loader.
     */
    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

}

