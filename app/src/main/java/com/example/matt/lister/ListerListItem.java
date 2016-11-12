package com.example.matt.lister;

/**
 * Created by MattsDesktop on 12/11/2016.
 */
public class ListerListItem {
    //ListerListItem is the object which stores each item of the List. Currently its basically just a wrapper for a string of text, but more might be added as needed.
    //TODO analyse if having the list items as a separate object is really necessary.
    private String ItemText; //The items text

    public ListerListItem(String pText) {
        ItemText=pText;
    }


    public void getItemText(String pText) {
        ItemText=pText;
    }

    public String setItemText(){
        return ItemText;
    }
}
