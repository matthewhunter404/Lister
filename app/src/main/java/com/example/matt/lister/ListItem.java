package com.example.matt.lister;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by matt on 2016/06/07.
 */
public class ListItem implements Serializable {
    private String ItemTitle;
    private String ItemDetails;
    private Vector<String> ItemDetailsVector=  new Vector<String>();
    private String[] ItemDetailLines=new String[5];
        public ListItem(){
            ItemTitle="";
            ItemDetails="";
            for(int i=0;i<5;i++){
                ItemDetailLines[i]="";
            }
        }

        public ListItem(String pItemTitle, String pItemDetails){
            ItemTitle=pItemTitle;
            ItemDetails=pItemDetails;
            String[] parts= pItemDetails.split("\\r?\\n");
            for(int i=0;i<5;i++){
                if (i<(parts.length-1)){
                    ItemDetailLines[i]=parts[i];
                }
                else{
                    ItemDetailLines[i]="";
                }
            }
        }
        public void setItemTitle(String pItemTitle){
            ItemTitle=pItemTitle;
        }
        public void setItemDetails(String pItemDetails){
            ItemDetails=pItemDetails;
            String[] parts= pItemDetails.split("\\r?\\n");
            for(int i=0;i<5;i++){
                if (i<(parts.length)){
                    ItemDetailLines[i]=parts[i];
                    ItemDetailsVector.add(parts[i]);
                }
                else{
                    ItemDetailLines[i]="";
                }
            }
        }
        public String getItemTitle(){
            return ItemTitle;
        }
        public String getItemDetails(){
            return ItemDetails;
        }

    public Vector<String>  getItemDetailsVector(){
        return ItemDetailsVector;
    }
        public String getItemDetailLine(int index)
        {
            return ItemDetailLines[index];
        }
    }
