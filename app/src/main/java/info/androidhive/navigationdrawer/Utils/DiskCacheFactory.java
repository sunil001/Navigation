package info.androidhive.navigationdrawer.Utils;

import android.content.Context;

import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;

import java.io.File;

/**
 * Created by sunilhl on 01/09/17.
 */

public class DiskCacheFactory extends DiskLruCacheFactory {

    DiskCacheFactory(final Context context, final String diskCacheName, long diskCacheSize) {
        super(new CacheDirectoryGetter() {
            @Override
            public File getCacheDirectory() {
                File cacheDirectory = new File(context.getExternalFilesDir(null), diskCacheName);
                return cacheDirectory;
            }

            /*File cacheDirectory = new File(context.getExternalFilesDir(null), diskCacheName);
            return cacheDirectory;*/
        }, (int) diskCacheSize);
    }
}
