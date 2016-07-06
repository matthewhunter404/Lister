package com.example.matt.lister;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MattsDesktop on 29/06/2016.
 */
public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //protected TextView vName;
        //protected TextView vSurname;
        //protected TextView vEmail;
        protected TextView vListItem;
        private Context mContext;

        public ListViewHolder(Context c,View v) {
            super(v);
            //vName =  (TextView) v.findViewById(R.id.txtName);
            //vSurname = (TextView)  v.findViewById(R.id.txtSurname);
            //vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            mContext=c;
            vListItem = (TextView) v.findViewById(R.id.ListItem);
            vListItem.setOnClickListener(this);
            v.setOnClickListener(this);
        }
    // Handles the row being being clicked
    @Override
    public void onClick(View view) {
        int position = getLayoutPosition(); // gets item position
        // We can access the data within the views
        Toast.makeText(mContext, vListItem.getText(), Toast.LENGTH_SHORT).show();
    }

    }

