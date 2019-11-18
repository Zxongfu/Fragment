package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    AFragment aFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //zzzz
        //newInstance() pattern
        aFragment = AFragment.newInstance("Hello");

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.frameLayout, aFragment, "aFragment");
//        fragmentTransaction.commit();

        //use Anonymous put AFragment into Activity
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, aFragment, "aFragment").commitAllowingStateLoss();
    }
}
