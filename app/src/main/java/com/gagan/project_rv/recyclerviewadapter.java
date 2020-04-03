package com.gagan.project_rv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class recyclerviewadapter extends RecyclerView.Adapter<recyclerviewadapter.viewHolder> {
    private static final String TAG = "recyclerviewadapter";
    private ArrayList<String> mImagesNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public recyclerviewadapter(Context mContext ,ArrayList<String> mImagesNames, ArrayList<String> mImages ) {
        this.mImagesNames = mImagesNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @Override
    public recyclerviewadapter.viewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.listitems,parent,false);
        viewHolder holder = new viewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder( viewHolder holder,  final int position) {
        Log.d(TAG,"onBindViewHolder:called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
        holder.imagename.setText(mImagesNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:clicked on:"+ mImagesNames.get(position));
                Toast.makeText(mContext,mImagesNames.get(position),Toast.LENGTH_SHORT).show();

            }


        });

    }

    @Override
    public int getItemCount() {
        return mImagesNames.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imagename;
        ConstraintLayout parentLayout;

        public viewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imagename = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent);
        }
    }
}