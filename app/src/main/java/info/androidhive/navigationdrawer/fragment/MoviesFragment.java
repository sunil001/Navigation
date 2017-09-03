package info.androidhive.navigationdrawer.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.adapters.ImageAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoviesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private File file = null;

    private OnFragmentInteractionListener mListener;

    public MoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoviesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoviesFragment newInstance(String param1, String param2) {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(getActivity(),"emoji"));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(getActivity(), "inside grid", Toast.LENGTH_SHORT).show();

                /*Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("image*//*");
                share.putExtra(Intent.EXTRA_TEXT, "Message");*/

                final Uri uria = Uri.parse("android.resource://" + getActivity().getPackageName() + "/drawable/emoji"+position);

                //File file = null;
                final File filea = null;
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        Looper.prepare();
                        try {
                            /*File file = Glide.
                                    with(getActivity().getApplicationContext()).
                                    load("https://www.google.es/images/srpr/logo11w.png").
                                    asBitmap().
                                    into(-1,-1).
                                    get();*/
                            file = Glide.with(getActivity().getApplicationContext())
                                    .load(uria)// uri to the location on the web where the image originates
                                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                    .get();
                        } catch (final ExecutionException e) {
                            //Log.e(TAG, e.getMessage());
                        } catch (final InterruptedException e) {
                            //Log.e(TAG, e.getMessage());
                        }
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Void dummy) {
                        if (null != file) {
                            String authority = "com.info.androidhive.navigationdrawer.fileprovider";
                            Uri uri = FileProvider.getUriForFile(getActivity().getApplicationContext(), authority, file);
                            if(uri!=null) {
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.putExtra(Intent.EXTRA_STREAM, uri);
                                intent.setType("image/*");
                                getActivity().startActivity(Intent.createChooser(intent, "Share via"));
                            }
                        };
                    }
                }.execute();

                /*try {
                    filea = Glide.with(getActivity().getApplicationContext())
                            .load(uria)// uri to the location on the web where the image originates
                            .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/

                /*String authority = "com.info.androidhive.navigationdrawer.android.fileprovider";
                Uri uri = FileProvider.getUriForFile(getActivity(), authority, file);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                intent.setType("image*//*");
                getActivity().startActivity(Intent.createChooser(intent, "Share via"));*/

               /* Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/drawable/emoji"+position);
                try {
                    InputStream stream = getActivity().getContentResolver().openInputStream(uri);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, uri);

                getActivity().startActivity(Intent.createChooser(share, "Share via"));*/
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
