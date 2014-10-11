package com.photoapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * This class encapsulates the Volley API resources such as Image Loader.
 * Follows the singleton pattern.
 * @author Aman Sharma
 *
 */
public class VolleyResources {
	
	
	private RequestQueue mRequestQueue;
	
	/* Image Loader Object is used by NetworkImageView from volleyAPI
	 * which allows images to be rendered from external Url
	 * */
	private ImageLoader mImageLoader;
	private static VolleyResources mInstance;
	
	private VolleyResources(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
		    private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
		    public void putBitmap(String url, Bitmap bitmap) {
		        mCache.put(url, bitmap);
		    }
		    public Bitmap getBitmap(String url) {
		        return mCache.get(url);
		    }
		});
	}
	
	public static VolleyResources getInstance(Context context) {
		if(mInstance == null) {
			mInstance = new VolleyResources(context);
		}
		
		return mInstance;
	}

	public RequestQueue getmRequestQueue() {
		return mRequestQueue;
	}

	public void setmRequestQueue(RequestQueue mRequestQueue) {
		this.mRequestQueue = mRequestQueue;
	}

	public ImageLoader getmImageLoader() {
		return mImageLoader;
	}

	public void setmImageLoader(ImageLoader mImageLoader) {
		this.mImageLoader = mImageLoader;
	}
	
	
}
