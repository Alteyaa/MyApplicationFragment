package io.geektech.myapplicationfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ChangeFragment extends Fragment implements IFragments{


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    IFragments iFragments;

    private ArrayList<MainModel> list;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    public ChangeFragment() {
    }

//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        iFragments = (IFragments) context;
//    }

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
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

        View view = inflater.inflate(R.layout.fragment_change, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        setupRecyclerView();
        return  view;
    }

    private void setupRecyclerView() {
        list = new ArrayList<>();
        list.add(new MainModel("Hello world","Мир здоровается"));
        list.add(new MainModel("Hello AIDARR","Мир здоровается"));
        list.add(new MainModel("Hello ALISA","Мир здоровается"));
        list.add(new MainModel("Hello world","Мир здоровается"));
        list.add(new MainModel("Hello world","Мир здоровается"));
        list.add(new MainModel("Hello world","Мир здоровается"));
        list.add(new MainModel("Hello world","Мир здоровается"));
        list.add(new MainModel("Hello world","Мир здоровается"));
        list.add(new MainModel("Hello world","Мир здоровается"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list,getActivity());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void displayDetails(String title, String subTitle) {
      MainActivity activity = (MainActivity) getActivity();
      activity.displayDetails(title,subTitle);
    }
}