package com.example.matt.lister;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by matt on 2016/06/10.
 */
public class ListFragment extends Fragment {
    private ListFragmentAdapter mListAdapter;
    private ListView mListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static ListFragment newInstance(ListItem theListItem) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("UriPlaceholder", theListItem);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        String listName;
        //String[] displayMainList= new String[6];
        Vector<String> displayMainList=  new Vector<String>();
        TextView titleText;
        ListItem theListItem= (ListItem) getArguments().getSerializable("UriPlaceholder");
        Log.d("0", "MMMOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        listName= theListItem.getItemTitle();
        displayMainList.add(0, theListItem.getItemDetails());
        mListAdapter =
                new ListFragmentAdapter(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item, // The name of the layout ID.
                        R.id.ListItem, // The ID of the textview to populate.
                        displayMainList);

        View rootView = inflater.inflate(R.layout.fragment_list,container, false);
        mListView = (ListView) rootView.findViewById(R.id.listitem_list);
        mListView.setAdapter(mListAdapter);
        titleText= (TextView) rootView.findViewById(R.id.TitleText);
        titleText.setText(listName);
        return rootView;
    }
}
