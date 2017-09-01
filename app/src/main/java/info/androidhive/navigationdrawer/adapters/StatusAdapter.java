package info.androidhive.navigationdrawer.adapters;

/**
 * Created by sunilhl on 29/08/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.Utils.Constants;
import info.androidhive.navigationdrawer.activity.MainActivity;
import info.androidhive.navigationdrawer.fragment.StatusDetailFragment;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {

    private List<String> statusList;
    private Activity context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    public StatusAdapter(List<String> statusList, Activity context) {
        this.statusList = statusList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.status_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    int latestPosition;
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //Status status = statusList.get(position);
        latestPosition = position;
        holder.title.setText(statusList.get(position));
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFragment(holder.title.getText().toString());
                Toast.makeText(context,holder.title.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return statusList.size();
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

    public void shareData(String shareText)
    {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "testing data"+" "+shareText);

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
