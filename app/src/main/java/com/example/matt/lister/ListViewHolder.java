package com.example.matt.lister;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MattsDesktop on 29/06/2016.
 */
public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //protected TextView vName;
        //protected TextView vSurname;
        //protected TextView vEmail;
        protected TextView vListItem;

        public ListViewHolder(View v) {
            super(v);
            //vName =  (TextView) v.findViewById(R.id.txtName);
            //vSurname = (TextView)  v.findViewById(R.id.txtSurname);
            //vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            vListItem = (TextView) v.findViewById(R.id.ListItem);
            vListItem.setOnClickListener(this);
            v.setOnClickListener(this);
        }
    @Override
    public void onClick(View v) {

    }

    }

