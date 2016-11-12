package com.example.matt.lister;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by matt on 2016/06/07.
 */
public class ListerList implements Serializable {
    //This is the basic object that stores all the data that makes up a list
    private String ListTitle; //The lists name
    private String ListDetails;
    private ArrayList<ListerListItem> ListDetailsArray=  new ArrayList();
    private Integer LineNumber=0;
    private String[] ListDetailLines=new String[5];
        public ListerList(){
            ListTitle="";
            ListDetails="";
            for(int i=0;i<5;i++){
                ListDetailLines[i]="";
            }
        }

        public ListerList(String pItemTitle, String pItemDetails){
            ListTitle=pItemTitle;
            ListDetails=pItemDetails;
            String[] parts= pItemDetails.split("\\r?\\n");
            for(int i=0;i<5;i++){
                if (i<(parts.length-1)){
                    ListDetailLines[i]=parts[i];
                }
                else{
                    ListDetailLines[i]="";
                }
            }
        }
        public void setListTitle(String pItemTitle){
            ListTitle=pItemTitle;
        }
        public void setListDetails(String pItemDetails){
            LineNumber=0;
            ListDetails=pItemDetails;
            String[] parts= pItemDetails.split("\\r?\\n");
            for(int i=0;i<5;i++) {
                ListDetailLines[i] = "";
            }
            for(int i=0;i<parts.length;i++){
                ListDetailsArray.add(new ListerListItem(parts[i]));
                LineNumber++;
                if (i<5){
                    ListDetailLines[i]=parts[i];
                }
            }
        }
        public String getListTitle(){
            return ListTitle;
        }
        public String getListDetails(){
            return ListDetails;
        }
        public Integer getLineNumber(){return LineNumber;}
        public ArrayList  getListDetailsArray(){
        return ListDetailsArray;
        }
        public String getListDetailLine(int index)
        {
            return ListDetailLines[index];
        }
        }
