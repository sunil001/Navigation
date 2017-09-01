package info.androidhive.navigationdrawer.adapters;

/**
 * Created by sunilhl on 30/08/17.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import info.androidhive.navigationdrawer.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String mData;
    private Intent shareIntent;

    // Keep all Images in array
    public Integer[] mEmojiIds = {
            R.drawable.emoji1, R.drawable.emoji2, R.drawable.emoji3, R.drawable.emoji4, R.drawable.emoji5,
            R.drawable.emoji6, R.drawable.emoji7, R.drawable.emoji8, R.drawable.emoji9, R.drawable.emoji10,
            R.drawable.emoji11, R.drawable.emoji12, R.drawable.emoji13, R.drawable.emoji14, R.drawable.emoji15,
            R.drawable.emoji16, R.drawable.emoji17, R.drawable.emoji18, R.drawable.emoji19, R.drawable.emoji20,
            R.drawable.emoji21, R.drawable.emoji22, R.drawable.emoji23, R.drawable.emoji24, R.drawable.emoji25,
            R.drawable.emoji26, R.drawable.emoji27, R.drawable.emoji28, R.drawable.emoji29, R.drawable.emoji30,
            R.drawable.emoji31, R.drawable.emoji32, R.drawable.emoji33, R.drawable.emoji34, R.drawable.emoji35,
            R.drawable.emoji36, R.drawable.emoji37, R.drawable.emoji38, R.drawable.emoji39, R.drawable.emoji40,
            R.drawable.emoji41, R.drawable.emoji42, R.drawable.emoji43, R.drawable.emoji44, R.drawable.emoji46,
            R.drawable.emoji47, R.drawable.emoji48, R.drawable.emoji49, R.drawable.emoji50, R.drawable.emoji51,
            R.drawable.emoji52, R.drawable.emoji53, R.drawable.emoji54, R.drawable.emoji55, R.drawable.emoji56,
            R.drawable.emoji57, R.drawable.emoji58, R.drawable.emoji59, R.drawable.emoji60, R.drawable.emoji61,
            R.drawable.emoji61, R.drawable.emoji62, R.drawable.emoji63, R.drawable.emoji64, R.drawable.emoji65,
            R.drawable.emoji66, R.drawable.emoji67, R.drawable.emoji68, R.drawable.emoji69, R.drawable.emoji70,
            R.drawable.emoji71, R.drawable.emoji72, R.drawable.emoji73, R.drawable.emoji74, R.drawable.emoji75,
            R.drawable.emoji76, R.drawable.emoji77, R.drawable.emoji78, R.drawable.emoji79, R.drawable.emoji80,
            R.drawable.emoji81, R.drawable.emoji82, R.drawable.emoji83, R.drawable.emoji84, R.drawable.emoji85,
            R.drawable.emoji86, R.drawable.emoji87, R.drawable.emoji88, R.drawable.emoji89, R.drawable.emoji90,
            R.drawable.emoji91, R.drawable.emoji92, R.drawable.emoji93, R.drawable.emoji94, R.drawable.emoji95,
            R.drawable.emoji96, R.drawable.emoji97, R.drawable.emoji98, R.drawable.emoji99, R.drawable.emoji100,
            R.drawable.emoji101, R.drawable.emoji102, R.drawable.emoji103, R.drawable.emoji105, R.drawable.emoji106,
            R.drawable.emoji107, R.drawable.emoji108, R.drawable.emoji109, R.drawable.emoji110, R.drawable.emoji111


    };

    // Keep all Images in array
    public Integer[] mLoveIds = {
            R.drawable.stick1, R.drawable.stick2, R.drawable.stick3, R.drawable.stick4, R.drawable.stick5,
            R.drawable.stick6, R.drawable.stick7, R.drawable.stick8, R.drawable.stick9, R.drawable.stick10,
            R.drawable.stick11, R.drawable.stick12, R.drawable.stick13, R.drawable.stick14, R.drawable.stick15,
            R.drawable.stick16, R.drawable.stick17, R.drawable.stick18, R.drawable.stick19, R.drawable.stick20,
            R.drawable.stick21, R.drawable.stick22, R.drawable.stick23, R.drawable.stick24, R.drawable.stick25,
            R.drawable.stick26, R.drawable.stick27, R.drawable.stick28, R.drawable.stick29, R.drawable.stick30,
            R.drawable.stick31, R.drawable.stick32, R.drawable.stick33, R.drawable.stick34, R.drawable.stick35,
            R.drawable.stick36, R.drawable.stick37, R.drawable.stick38, R.drawable.stick39, R.drawable.stick40,
            R.drawable.stick41, R.drawable.stick42, R.drawable.stick43, R.drawable.stick44, R.drawable.stick45,
            R.drawable.stick46
    };

    // Constructor
    public ImageAdapter(Context c, String data) {
        mContext = c;
        mData = data;
    }

    @Override
    public int getCount() {
        if (mData.equals("love")) {
            return mLoveIds.length;
        } else {
            return mEmojiIds.length;
        }
    }

    @Override
    public Object getItem(int position) {
        if (mData.equals("love")) {
            return mLoveIds[position];
        } else {
            return mEmojiIds[position];
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int color = 0xFF0000FF;
        final ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
        }else{
            imageView = (ImageView)convertView;
        }
        if (mData.equals("love")) {
            imageView.setImageResource(mLoveIds[position]);
            /*Glide.with(mContext).load(mLoveIds[position])
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            prepareShareIntent(((GlideBitmapDrawable) resource).getBitmap());
                            attachShareIntentAction();
                            // Let Glide handle resource load
                            return false;
                        }
                    }).into(imageView);*/
        } else {
            imageView.setImageResource(mEmojiIds[position]);
            /*Glide.with(mContext).load(mEmojiIds[position])
                    .listener(new RequestListener<Uri, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            prepareShareIntent(((GlideBitmapDrawable) resource).getBitmap());
                            attachShareIntentAction();
                            // Let Glide handle resource load
                            return false;
                        }
                    }).into(imageView);
        }*/
        /*if(imageView!=null) {
            ((BitmapDrawable) imageView.getDrawable()).getBitmap().recycle();
        }*/
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setDrawingCacheEnabled(true);
            imageView.buildDrawingCache();

            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Uri bmpUri = getLocalBitmapUri(imageView);
                    if (bmpUri != null) {
                        // Construct a ShareIntent with link to image
                        Intent share = new Intent(android.content.Intent.ACTION_SEND);
                        share.setType("image*//*");
                        share.putExtra(Intent.EXTRA_TEXT, "Message");
                        share.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    /*shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    shareIntent.setType("image*//*");*/
                        // Launch sharing dialog for image
                        mContext.startActivity(Intent.createChooser(share, "Share Image"));
                    } else {
                        // ...sharing failed, handle error
                    }


                }

            });
            //convertView.setBackgroundColor(color);
           // return imageView;
        }
        return imageView;
    }




    // Returns the URI path to the Bitmap displayed in specified ImageView
    public Uri getLocalBitmapUri(ImageView imageView) {
        // Extract Bitmap from ImageView drawable
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable){
            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        } else {
            return null;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        try {
            // Use methods on Context to access package-specific directories on external storage.
            // This way, you don't need to request external read/write permission.
            // See https://youtu.be/5xVh-7ywKpE?t=25m25s
            File file =  new File(mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            // **Warning:** This will fail for API >= 24, use a FileProvider as shown below instead.
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    //new

    // Gets the image URI and setup the associated share intent to hook into the provider
    /*public void prepareShareIntent(Bitmap drawableImage) {
        // Fetch Bitmap Uri locally
        Uri bmpUri = getBitmapFromDrawable(drawableImage);// see previous remote images section and notes for API > 23
        // Construct share intent as described above based on bitmap
        shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
        shareIntent.setType("image*//*");
    }*/

    // Attaches the share intent to the share menu item provider
    /*public void attachShareIntentAction() {
        if (miShareAction != null && shareIntent != null)
            miShareAction.setShareIntent(shareIntent);
    }*/

}
