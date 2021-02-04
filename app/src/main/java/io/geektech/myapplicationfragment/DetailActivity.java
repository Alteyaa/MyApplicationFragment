package io.geektech.myapplicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private String title;
    private String subTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent!=null){
            title = intent.getStringExtra("key");
            subTitle = intent.getStringExtra("keyDesc");
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TExtFragment fragment =new TExtFragment();
        transaction.add(R.id.contentMain,fragment);
        transaction.commit();
    }
}