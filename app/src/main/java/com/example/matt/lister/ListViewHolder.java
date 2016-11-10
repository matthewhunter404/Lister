package com.example.matt.lister;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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
        Button undoButton;
        private Context mContext;

        public ListViewHolder(Context c,View v) {
            super(v);
            //vName =  (TextView) v.findViewById(R.id.txtName);
            //vSurname = (TextView)  v.findViewById(R.id.txtSurname);
            //vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            mContext=c;
            vListItem = (TextView) v.findViewById(R.id.ListItem);
            undoButton = (Button) itemView.findViewById(R.id.undo_button);
            vListItem.setOnClickListener(this);
            v.setOnClickListener(this);
        }
    // Handles the row being being clicked
    @Override
    public void onClick(View view) {

//        int pos = getAdapterPosition();
//        int position = getLayoutPosition(); // gets item position
//        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
//        alert.setTitle("Title");
//        alert.setMessage("Message");
//
//        // Set an EditText view to get user input
//        final EditText input = new EditText(mContext);
//        input.setTextColor(Color.parseColor("#646464"));
//        alert.setView(input);
//        input.setText(vListItem.getText());
//        final int passedPosition = position;
//        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//        public void onClick(DialogInterface dialog, int pPosition) {
//
//        //mDisplayMainList.set(passedPosition, input.getText().toString());
//        //((BaseAdapter) RecyclerView.getAdapter()).notifyDataSetChanged();
//        }
//        });
//
//        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//        public void onClick(DialogInterface dialog, int whichButton) {
//        // Canceled.
//        }
//        });
//
//        alert.show();
        }
    }

