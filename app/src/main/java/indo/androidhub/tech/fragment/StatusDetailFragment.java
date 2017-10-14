package indo.androidhub.tech.fragment;

/**
 * Created by sunilhl on 30/08/17.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import indo.androidhub.tech.R;
import indo.androidhub.tech.Utils.Constants;
import indo.androidhub.tech.adapters.StatusDetailAdapter;

public class StatusDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    /*private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";*/

    // TODO: Rename and change types of parameters
    private String selectedKey;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerView;
    StatusDetailAdapter statusDetailAdapter;

    public StatusDetailFragment() {
        // Required empty public constructor
    }

    public static StatusDetailFragment newInstance(String param1, String param2) {
        StatusDetailFragment fragment = new StatusDetailFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getArguments() != null) {
            selectedKey = getArguments().getString(Constants.SELECTED_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status_detail, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.status_list_detail);

        String[] statusa = new String[0];
        if(selectedKey.equals("Love")) {
           statusa = getActivity().getResources().getStringArray(R.array.love_data);
        }else{
            Toast.makeText(getActivity(),"selection",Toast.LENGTH_SHORT).show();
        }

        List<String> statusList = Arrays.asList(statusa);
        System.out.println("sunil"+ statusa.length +" "+ statusList.size());

        statusDetailAdapter = new StatusDetailAdapter(statusList, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(statusDetailAdapter);

        //statusDetailAdapter.notifyDataSetChanged();

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}

