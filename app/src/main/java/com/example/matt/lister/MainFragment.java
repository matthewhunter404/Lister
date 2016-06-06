package com.example.matt.lister;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matt on 2016/05/26.
 */
public class MainFragment extends Fragment {
    ArrayAdapter<String> mMainListAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        String[] data = {
                "example1",
                "example2",
                "example3",
                "example4",
                "example5"
        };
        List<String> mainList = new ArrayList<String>(Arrays.asList(data));

        // The ArrayAdapter will take data from a source (like our dummy data) and
        // use it to populate the ListView it's attached to.
        mMainListAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.main_list_item, // The name of the layout ID.
                        R.id.ItemTitle, // The ID of the textview to populate.
                        mainList);

        View rootView = inflater.inflate(R.layout.fragment_main,container, false);
        final ListView listView = (ListView) rootView.findViewById(R.id.listview_main);
        listView.setAdapter(mMainListAdapter);
        return rootView;
    }

}
