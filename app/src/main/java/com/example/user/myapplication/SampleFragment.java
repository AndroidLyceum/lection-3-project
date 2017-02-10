package com.example.user.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 10.02.2017.
 */

public class SampleFragment extends Fragment {

    private static final String KEY_COUNTER = "KEY_COUNTER";

    private int selfCount;

    private TextView tvSample;

    public static SampleFragment nextFragment(SampleFragment fragment) {
        Bundle args = new Bundle();
        SampleFragment newFragment = new SampleFragment();

        if(fragment != null) {
            args.putInt(KEY_COUNTER, fragment.selfCount + 1);
        } else {
            args.putInt(KEY_COUNTER, 1);
        }

        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null) {
            selfCount = args.getInt(KEY_COUNTER);
        } else {
            selfCount = savedInstanceState.getInt(KEY_COUNTER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sample, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        tvSample = (TextView) view.findViewById(R.id.fragment_sample_tv);
        tvSample.setText("Идентификатор: " + String.valueOf(selfCount));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, selfCount);
    }
}
