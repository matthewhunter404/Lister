package com.example.matt.lister;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by matt on 2016/06/07.
 */

public class ListFragmentAdapter extends RecyclerView.Adapter<ListViewHolder> {
    ArrayList<String> mDataset= new ArrayList();
    List<String> itemsPendingRemoval;
    boolean undoOn; // is undo on, you can turn it on from the toolbar menu
    private Handler handler = new Handler(); // hanlder for running delayed runnables
    HashMap<String, Runnable> pendingRunnables = new HashMap<>(); // map of items to pending runnables, so we can cancel a removal if need be
    private static final int PENDING_REMOVAL_TIMEOUT = 3000; // 3sec

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListFragmentAdapter(ArrayList myDataset) {
        mDataset = myDataset;
    }

    //private final View.OnClickListener mOnClickListener = new MyOnClickListener();
    // Create new views (invoked by the layout manager)
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ListViewHolder vh = new ListViewHolder(parent.getContext(),v);

        //v.setOnClickListener(mOnClickListener);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        ListViewHolder viewHolder = (ListViewHolder)holder;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.vListItem.setText(mDataset.get(position));
        final String item=mDataset.get(position);

        if (itemsPendingRemoval.contains(item)) {
            // we need to show the "undo" state of the row
            viewHolder.itemView.setBackgroundColor(Color.RED);
            viewHolder.vListItem.setVisibility(View.GONE);
            viewHolder.undoButton.setVisibility(View.VISIBLE);
            viewHolder.undoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // user wants to undo the removal, let's cancel the pending task
                    Runnable pendingRemovalRunnable = pendingRunnables.get(item);
                    pendingRunnables.remove(item);
                    if (pendingRemovalRunnable != null) handler.removeCallbacks(pendingRemovalRunnable);
                    itemsPendingRemoval.remove(item);
                    // this will rebind the row in "normal" state
                    notifyItemChanged(mDataset.indexOf(item));
                }
            });
        } else {
            // we need to show the "normal" state
            viewHolder.itemView.setBackgroundColor(Color.WHITE);
            viewHolder.vListItem.setVisibility(View.VISIBLE);
            viewHolder.vListItem.setText(item);
            viewHolder.undoButton.setVisibility(View.GONE);
            viewHolder.undoButton.setOnClickListener(null);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setUndoOn(boolean undoOn) {
        this.undoOn = undoOn;
    }

    public boolean isUndoOn() {
        return undoOn;
    }

    public void pendingRemoval(int position) {
        final String item = mDataset.get(position);
        if (!itemsPendingRemoval.contains(item)) {
            itemsPendingRemoval.add(item);
            // this will redraw row in "undo" state
            notifyItemChanged(position);
            // let's create, store and post a runnable to remove the item
            Runnable pendingRemovalRunnable = new Runnable() {
                @Override
                public void run() {
                    remove(mDataset.indexOf(item));
                }
            };
            handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT);
            pendingRunnables.put(item, pendingRemovalRunnable);
        }
    }

    //Simple remove method to remove the line item stored at the passed position
    public void remove(int position) {
        String item = mDataset.get(position);
        if (itemsPendingRemoval.contains(item)) {
            itemsPendingRemoval.remove(item);
        }
        if (mDataset.contains(item)) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }

    public boolean isPendingRemoval(int position) {
        String item = mDataset.get(position);
        return itemsPendingRemoval.contains(item);
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




//// Provide a reference to the views for each data item
//// Complex data items may need more than one view per item, and
//// you provide access to all the views for a data item in a view holder
//public static class ViewHolder extends RecyclerView.ViewHolder {
//    // each data item is just a string in this case
//    public TextView mTextView;
//    public ViewHolder(View v) {
//        super(v);
//        mTextView = (TextView)itemView.findViewById(R.id.ListItem);
//
//    }
//}