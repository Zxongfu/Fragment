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
    BFragment bFragment;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                    // B replace A
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, bFragment).commitAllowingStateLoss();
                }
            }
        });

        //newInstance() pattern
        aFragment = AFragment.newInstance("Hello");

//        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.frameLayout, aFragment);
//        fragmentTransaction.commitAllowingStateLoss();

        //use Anonymous put AFragment into Activity
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, aFragment).commitAllowingStateLoss();
    }
}
