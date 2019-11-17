package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AFragment extends Fragment {
    private TextView textView;
    private View view;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.a_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textView = view.findViewById(R.id.textView);
        if (getArguments() != null) {
            textView.setText(getArguments().getString("title"));
        }
    }
}
