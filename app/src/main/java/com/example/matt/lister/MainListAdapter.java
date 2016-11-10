package com.example.matt.lister;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by matt on 2016/06/07.
 */
public class MainListAdapter extends ArrayAdapter<ListItem> {

        Context context;
        int layoutResourceId;
        ListItem data[] = null;

        public MainListAdapter(Context context, int layoutResourceId, int textlayoutResourceId,  ListItem[] data) {
            super(context, layoutResourceId,textlayoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            MainAdapterHolder holder = null;

            if(row == null)
            {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                row.setTag(holder);
            }
            else
            {
                holder = (MainAdapterHolder)row.getTag();
            }
            holder = new MainAdapterHolder();
            holder.Item_Title_textview = (TextView)row.findViewById(R.id.ItemTitle);
            String titleText = data[position].getItemTitle();
            holder.Item_Title_textview.setText(titleText);
            holder.Item_Detail1_textview = (TextView)row.findViewById(R.id.ItemDetail1);
            holder.Item_Detail2_textview = (TextView)row.findViewById(R.id.ItemDetail2);
            holder.Item_Detail3_textview = (TextView)row.findViewById(R.id.ItemDetail3);
            holder.Item_Detail4_textview = (TextView)row.findViewById(R.id.ItemDetail4);
            holder.Item_Detail1_textview.setText(data[position].getItemDetailLine(1));
            holder.Item_Detail2_textview.setText(data[position].getItemDetailLine(2));
            holder.Item_Detail3_textview.setText(data[position].getItemDetailLine(3));
            holder.Item_Detail4_textview.setText(data[position].getItemDetailLine(4));
            return row;
        }

        static class MainAdapterHolder
        {
            TextView Item_Title_textview;
            TextView Item_Detail1_textview;
            TextView Item_Detail2_textview;
            TextView Item_Detail3_textview;
            TextView Item_Detail4_textview;
        }
    }




