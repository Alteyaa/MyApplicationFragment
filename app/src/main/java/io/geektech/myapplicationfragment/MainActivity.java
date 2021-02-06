package io.geektech.myapplicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements IFragments {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private View fragmentView;
    private boolean isSecondFragment = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentView = findViewById(R.id.fragment_second);
        if (fragmentView !=null){
            isSecondFragment = true;
        }

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_first,new ChangeFragment());
        transaction.commit();
    }

    @Override
    public void displayDetails(String title, String subTitle) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            TExtFragment fragment = (TExtFragment) fragmentManager.findFragmentById(R.id.fragment_second);
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            fragment.showText(title, subTitle);
            transaction.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("key", title);
            intent.putExtra("keyDesc", subTitle);
            startActivity(intent);
        }
    }
}