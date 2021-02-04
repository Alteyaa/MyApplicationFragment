package io.geektech.myapplicationfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TExtFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tExtView;
    private TextView txtSubTitle;

    private Button btnChild;

    private Fragment parent;



    public TExtFragment() {
        // Required empty public constructor
    }


    public static TExtFragment newInstance(Fragment parent) {
        TExtFragment fragment = new TExtFragment();
        Bundle args = new Bundle();
        fragment.parent = parent;
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
        View view= inflater.inflate(R.layout.fragment_t_ext, container, false);
        tExtView = view.findViewById(R.id.txtView);
        txtSubTitle = view.findViewById(R.id.txtSubTitle);
        btnChild = view.findViewById(R.id.btnChild);
        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChildFragment(ChildFragment.newInstance(TExtFragment.this, "Hello from parent fragment"),ChildFragment.TAG);
            }
        });

        return  view;
    }

    public void showChildFragment(Fragment fragment, String tag){
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_parent,fragment,tag);
        transaction.commit();
    }

    public  void showText(String text,String subTitle){
        tExtView.setText(text);
        txtSubTitle.setText(subTitle);
    }
}