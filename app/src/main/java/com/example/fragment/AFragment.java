package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AFragment extends Fragment {
    private static final String TAG = "AFragment";
    private Button button;
    private TextView textView;
    private View view;
    BFragment bFragment;
    AFragment aFragment;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        view = inflater.inflate(R.layout.a_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textView = view.findViewById(R.id.textView);

        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if bfragment equals null create bFragment
                if (bFragment == null) {
                    bFragment = new BFragment();
                }

                //if  getFragmentManager() not equals null
                if (getFragmentManager() != null) {
                    Fragment fragment = getFragmentManager().findFragmentByTag("aFragment");
                    //if fragment tag not equals null
                    if (fragment != null) {
                        getFragmentManager().beginTransaction().hide(fragment).add(R.id.frameLayout, bFragment, "bFragment").addToBackStack(null).commitAllowingStateLoss();
//                        FragmentManager fragmentManager = getFragmentManager();
//                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                        Fragment f = fragmentManager.findFragmentByTag("aFragment");
//                        fragmentTransaction.hide(f);
//                        fragmentTransaction.add(R.id.frameLayout, bFragment, "bFragment");
//                        fragmentTransaction.commit();
                    }
                }

            }
        });

        if (getArguments() != null) {
            textView.setText(getArguments().getString("title"));
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
}
