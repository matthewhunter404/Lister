package com.example.matt.lister;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by matt on 2016/06/10.
 */
public class ListFragment extends Fragment {
    private RecyclerView.Adapter mListAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext;
    private ArrayList<String> mDisplayMainList;

    //Quick note on vector vs arraylist
    //Performance: ArrayList gives better performance as it is non-synchronized. Vector operations gives poor performance as they are thread-safe, the thread which works on Vector gets a lock on it which makes other thread wait till the lock is released.
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
        mContext=this.getActivity();
        //String[] displayMainList= new String[6];
        TextView titleText;
        ListItem theListItem= (ListItem) getArguments().getSerializable("UriPlaceholder");
        mDisplayMainList=  theListItem.getItemDetailsArray();
        listName= theListItem.getItemTitle();
        //displayMainList.add(0, theListItem.getItemDetails());
//        mListAdapter =
//                new ListFragmentAdapter(
//                        getActivity(), // The current context (this activity)
//                        R.layout.list_item, // The name of the layout ID.
//                        R.id.ListItem, // The ID of the textview to populate.
//                        mDisplayMainList);

        View rootView = inflater.inflate(R.layout.fragment_list,container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.listitem_recycler);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);// use a linear layout manager

        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mListAdapter = new ListFragmentAdapter(mDisplayMainList);
        mRecyclerView.setAdapter(mListAdapter);

        titleText = (TextView) rootView.findViewById(R.id.TitleText);
        titleText.setText(listName);

        //Code for the add list item option as a floating Action Button. This should maybe reuse code from edit popup window, but the key difference is mDisplayMainList.set vs mDisplayMainList.add which is at the centre of the method
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("Title");
                alert.setMessage("Message");
                // Set an EditText view to get user input
                final EditText input = new EditText(mContext);
                input.setTextColor(Color.parseColor("#646464"));
                alert.setView(input);
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int pPosition) {

                        mDisplayMainList.add(mDisplayMainList.size(), input.getText().toString());
                        //((BaseAdapter) mRecyclerView.getAdapter()).notifyDataSetChanged();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();
            }
        });

        return rootView;
    }
}


//mRecyclerView.OnItemTouchListener(new AdapterView.OnItemClickListener() {
//@Override
//public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
//        alert.setTitle("Title");
//        alert.setMessage("Message");
//
//// Set an EditText view to get user input
//final EditText input = new EditText(mContext);
//        input.setTextColor(Color.parseColor("#646464"));
//        alert.setView(input);
//        input.setText(mDisplayMainList.get(position));
//final int passedPosition = position;
//        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int pPosition) {
//
//        mDisplayMainList.set(passedPosition, input.getText().toString());
//        ((BaseAdapter) mRecyclerView.getAdapter()).notifyDataSetChanged();
//        }
//        });
//
//        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int whichButton) {
//        // Canceled.
//        }
//        });
//
//        alert.show();
//        }
//        });