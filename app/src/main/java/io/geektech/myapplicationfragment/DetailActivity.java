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
        TExtFragment fragment = (TExtFragment) fragmentManager.findFragmentById(R.id.fragmentText);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragment.showText(title,subTitle);
        transaction.commit();
    }
}