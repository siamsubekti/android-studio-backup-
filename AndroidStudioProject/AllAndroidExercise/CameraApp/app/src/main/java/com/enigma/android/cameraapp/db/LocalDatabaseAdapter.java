package com.enigma.android.cameraapp.db;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enigma.android.cameraapp.Fragment.LocalFragment;
import com.enigma.android.cameraapp.MainActivity;
import com.enigma.android.cameraapp.R;

import java.util.ArrayList;

public class LocalDatabaseAdapter extends RecyclerView.Adapter<LocalDatabaseAdapter.MyViewHolder> {
    Context context;
    ArrayList<LocalResponse> singleRowArrayList;
    SQLiteDatabase db;
    DataBaseHandler myDatabase;

    public LocalDatabaseAdapter(Context context, ArrayList<LocalResponse> singleRowArrayList, SQLiteDatabase db, DataBaseHandler myDatabase) {
        this.context = context;
        this.singleRowArrayList = singleRowArrayList;
        this.db = db;
        this.myDatabase = myDatabase;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.local_database_items, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {
        holder.newsImage.setImageBitmap(getBitmapFromEncodedString(singleRowArrayList.get(i).image));
//        holder.imageHome.setImageBitmap(getBitmapFromEncodedString(singleRowArrayList.get(i).image));
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.home.setImageBitmap(getBitmapFromEncodedString(singleRowArrayList.get(i).image));
            }
        });
        //  myViewHolder.id.setText(singleRowArrayList.get(i).uid);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletedata(i,singleRowArrayList);
            }
        });
    }

    @Override
    public int getItemCount() {

        return singleRowArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage,delete, edit, home;
        TextView id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage =  itemView.findViewById(R.id.newsImage);
            delete =  itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
            home = itemView.findViewById(R.id.image_home);
        }
    }

    public void deletedata(final int position, final ArrayList<LocalResponse> singleRowArrayList){
        new AlertDialog.Builder(context)
                .setIcon(R.drawable.defaultimage)
                .setTitle("Delete result")
                .setMessage("Are you sure you want delete this result?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /* This is where deletions should be handled */
                        myDatabase.deleteEntry(singleRowArrayList.get(position).getUid());
                        singleRowArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyDataSetChanged();
                        myDatabase.close();
                        ((MainActivity) context).loadFragment(new LocalFragment(), true);

                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

//    public void editdata(final int position, final ArrayList<LocalResponse> singleRowArrayList) {
//        new AlertDialog.Builder(context)
//                .setIcon(R.drawable.logo_open)
//                .setTitle("Take photo")
//                .setMessage("Are you sure take this photo ?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent(LocalDatabaseAdapter.this, MainActivity.class);
//
//                    }
//                })
//    }


    private Bitmap getBitmapFromEncodedString(String encodedString){

        byte[] arr = Base64.decode(encodedString, Base64.URL_SAFE);

        Bitmap img = BitmapFactory.decodeByteArray(arr, 0, arr.length);

        return img;

    }
}
