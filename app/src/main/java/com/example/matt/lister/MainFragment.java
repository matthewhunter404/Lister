package com.example.matt.lister;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by matt on 2016/05/26.
 */
public class MainFragment extends Fragment {
    MainListAdapter mMainListAdapter;
    private ListView mListView;
    final int displaySize=5;
    ListItem displayMainList[]= new ListItem[displaySize];
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


        return rootView;
    }
    public void setData(String[] pTitles, String[] pDetails) {
        for(int i=0;i<5;i++) {
            Log.d("moo",Integer.toString(i));
            displayMainList[i]=new ListItem();
            displayMainList[i].setItemTitle(pTitles[i]);
            displayMainList[i].setItemDetails(pDetails[i]);
        }
    }
}
