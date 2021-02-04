package io.geektech.myapplicationfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ChildFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "ChildFragment";


    private String mParam1;
    private String mParam2;

    private Fragment parent;

    public ChildFragment() {
        // Required empty public constructor
    }


    public static ChildFragment newInstance( TExtFragment fragmentParent, String param2) {
        ChildFragment fragment = new ChildFragment();
        fragment.parent= fragmentParent;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_child, container, false);
        TextView txtView = view.findViewById(R.id.txtView);

        if (mParam2 != null) {
            txtView.setText(mParam2);
        }
        return view;
    }
}