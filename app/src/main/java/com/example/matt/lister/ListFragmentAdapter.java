package com.example.matt.lister;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by matt on 2016/06/07.
 */

public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ContactViewHolder> {

    private List<ListItem> contactList;

    public ListFragmentAdapter(List<ListItem> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
        ListItem ci = contactList.get(i);
        listViewHolder.vListItem.setText(ci.name);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

    }
}

//public class ListFragmentAdapter extends ArrayAdapter<String> {
//
//        Context context;
//        int layoutResourceId;
//        ArrayList<String> data = new ArrayList();
//
//        public ListFragmentAdapter(Context context, int layoutResourceId, int textlayoutResourceId, ArrayList data) {
//            super(context, layoutResourceId,textlayoutResourceId, data);
//            this.layoutResourceId = layoutResourceId;
//            this.context = context;
//            this.data = data;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View row = convertView;
//            ListFragmentAdapterHolder holder = null;
//
//            if(row == null)
//            {
//                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
//                row = inflater.inflate(layoutResourceId, parent, false);
//                row.setTag(holder);
//            }
//            else
//            {
//                holder = (ListFragmentAdapterHolder)row.getTag();
//            }
//            holder = new ListFragmentAdapterHolder();
//            holder.List_Line= (TextView)row.findViewById(R.id.ListItem);
//            String ListText = data.get(position);
//            holder.List_Line.setText(ListText);
//            Log.d("0", ListText);
//            return row;
//        }
//
//        static class ListFragmentAdapterHolder
//        {
//            TextView List_Line;
//        }
//    }




