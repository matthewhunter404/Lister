package com.example.matt.lister;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by matt on 2016/06/10.
 */
public class ListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        String ListName;
        String[] ListDetails;
        View rootView = inflater.inflate(R.layout.fragment_list,container, false);
        return rootView;
    }
}
