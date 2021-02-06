package io.geektech.myapplicationfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ChildFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "ChildFragment";


    private int mParam1;
    private String mParam2;

    private TextView txtSkip;
    private TextView txtNext;

    private ViewPager viewPager;

    private Fragment parent;

    public ChildFragment() {
        // Required empty public constructor
    }


    public static ChildFragment newInstance( TExtFragment fragmentParent, String param2,int image) {
        ChildFragment fragment = new ChildFragment();
        fragment.parent= fragmentParent;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM1, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_child, container, false);
        txtSkip = view.findViewById(R.id.txtSkip);
        txtNext = view.findViewById(R.id.txtNext);
        ImageView imageView = view.findViewById(R.id.imageView);
        viewPager = getActivity().findViewById(R.id.viewPager);

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            OnBoardingActivity activity = (OnBoardingActivity) getActivity();
            activity.showMain();

            }
        });

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        if (mParam1 != 0 ) {
            imageView.setImageResource(mParam1);
        }
        return view;
    }
}