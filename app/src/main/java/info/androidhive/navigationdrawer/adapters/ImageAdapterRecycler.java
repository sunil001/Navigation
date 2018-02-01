package info.androidhive.navigationdrawer.adapters;

/**
 * Created by sunilhl on 29/08/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.Utils.Constants;
import info.androidhive.navigationdrawer.activity.MainActivity;
import info.androidhive.navigationdrawer.fragment.StatusDetailFragment;

public class ImageAdapterRecycler extends RecyclerView.Adapter<ImageAdapterRecycler.MyViewHolder> {

    private String statusList;
    private Activity context;
    Integer[] data;

    // Keep all Images in array
    /*public Integer[] mEmojiIds = {
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


    };*/

    public Integer[] mEmojiIds = {
            R.drawable.emoji141, R.drawable.emoji142, R.drawable.emoji143, R.drawable.emoji144, R.drawable.emoji145, R.drawable.emoji146,
            R.drawable.emoji147, R.drawable.emoji148, R.drawable.emoji149, R.drawable.emoji150, R.drawable.emoji151,
            R.drawable.emoji152, R.drawable.emoji153, R.drawable.emoji154, R.drawable.emoji156,
            R.drawable.emoji157, R.drawable.emoji158, R.drawable.emoji159, R.drawable.emoji160, R.drawable.emoji161,
            R.drawable.emoji161, R.drawable.emoji162, R.drawable.emoji164, R.drawable.emoji166


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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView logo;

        public MyViewHolder(View view) {
            super(view);
            logo = (ImageView) view.findViewById(R.id.logo);
        }
    }


    public ImageAdapterRecycler(String statusList, Activity context) {
        //this.statusList = statusList;
        this.context = context;
        statusList = "test";
        if(statusList.equals("love"))
        {
            data = mLoveIds;
        }else{
            data = mEmojiIds;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.status_grid_row, parent, false);

        return new MyViewHolder(itemView);
    }

    //int latestPosition;
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //Status status = statusList.get(position);
        //latestPosition = position;
        holder.logo.setImageResource(data[position]);
        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareLogoData(holder.getAdapterPosition());

            }
        });
        //holder.title.setText(statusList.get(position));
        /*holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFragment(holder.title.getText().toString());
                Toast.makeText(context,holder.title.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    private void goToFragment(String selectedItem) {
        StatusDetailFragment mFragment = new StatusDetailFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(Constants.SELECTED_KEY, selectedItem);
        mFragment.setArguments(mBundle);
        switchContent(R.id.frame, mFragment);
    }

    public void switchContent(int id, Fragment fragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            //FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
            FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.replace(id, fragment, fragment.toString());
            //ft.addToBackStack(null);
            ft.commit();
        }

    }

    public void shareLogoData(int position)
    {
        /*Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "testing data"+" "+shareText);

        context.startActivity(Intent.createChooser(share, "Share via"));*/


        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("image*//*");
        share.putExtra(Intent.EXTRA_TEXT, "Message");

        Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/drawable/emoji"+position);
        try {
            InputStream stream = context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        share.putExtra(Intent.EXTRA_STREAM, uri);

        context.startActivity(Intent.createChooser(share, "Share via"));
    }

    public void copyClipBoard(String copyText)
    {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
            clipboard.setText(copyText);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", copyText);
            clipboard.setPrimaryClip(clip);
        }
    }
}
