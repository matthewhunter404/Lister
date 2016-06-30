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

public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ViewHolder> {
    ArrayList<String> mDataset= new ArrayList();
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)itemView.findViewById(R.id.ListItem);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListFragmentAdapter(ArrayList myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
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




