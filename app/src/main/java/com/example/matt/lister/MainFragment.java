package com.example.matt.lister;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by matt on 2016/05/26.
 */
public class MainFragment extends Fragment {
    private MainListAdapter mMainListAdapter;
    private OnListSelectedListener mListener;

    private ListView mListView;
    final int displaySize=5;
    ListerList displayMainList[]= new ListerList[displaySize];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        String[] Titles = {
                "Shopping List",
                "Grocery List",
                "To Do",
                "Directions",
                "Recipe"
        };
        String[] Details = {
                "This is a description of things to buy \n Bread \n Cheese \n Ham \n More Cheese" ,
                "This is a another description of more things to buy \n" + " Chocolate \n" + " Ice Cream \n" + " Pudding \n" + " Dishwashing Liquid \n"+ " Handy Andy \n"+ "  Soap \n"+ " Mouth Wash \n"+ " Nasal Spray \n"+ " Vics Vapourrub \n"+ " Apples \n"+ " Cream \n" + "  Cream Cheese \n"+ "  Handy Andy \n",
                "To Do \n Clean Room \n Eat Breakfast \n Go back to bed",
                "Route: \n Take N3 from Durban \n take the turn off at the R43 \n Crash",
                "Recipe: \n Pound of flour \n 2 eggs \n Eye of Newt \n Tail of Dog \n Instructions: \n Boil Boil toil and trouble, etc"
        };
        setData(Titles,Details);
        mMainListAdapter =
                new MainListAdapter(
                        getActivity(), // The current context (this activity)
                        R.layout.main_list_item, // The name of the layout ID.
                        R.id.ItemTitle, // The ID of the textview to populate.
                        displayMainList);

        View rootView = inflater.inflate(R.layout.fragment_main,container, false);
        mListView = (ListView) rootView.findViewById(R.id.listview_main);
        mListView.setAdapter(mMainListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //String Answer = mMainListAdapter.getItem(position).getItemTitle();
                mListener.onListSelected(mMainListAdapter.getItem(position));

            }
        });
        return rootView;
    }
    public void setData(String[] pTitles, String[] pDetails) {
        for(int i=0;i<displaySize;i++) {
            //TODO make this initialise the data in sql form
            Log.d("moo",Integer.toString(i));
            displayMainList[i]=new ListerList();
            displayMainList[i].setListTitle(pTitles[i]);
            displayMainList[i].setListDetails(pDetails[i]);
        }
    }

    public interface OnListSelectedListener {
        public void onListSelected(ListerList selectedList);
    }

    //Then the activity that hosts the fragment implements the OnArticleSelectedListener interface and overrides onArticleSelected()
    //to notify fragment B of the event from fragment A. To ensure that the host activity implements this interface, fragment A's
    // onAttach() callback method (which the system calls when adding the fragment to the activity) instantiates an instance of
    // OnArticleSelectedListener by casting the Activity that is passed into onAttach():
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnListSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnListSelectedListener");
        }
    }


}
