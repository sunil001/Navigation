package info.androidhive.navigationdrawer.Utils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by sunilhl on 01/09/17.
 */

public class MyGlideModule implements GlideModule {
    private static final int IMAGE_CACHE_SIZE = 200_000_000;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDiskCache(new DiskCacheFactory(context, ".", IMAGE_CACHE_SIZE));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }

}
