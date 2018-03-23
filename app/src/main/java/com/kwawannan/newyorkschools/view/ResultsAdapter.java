package com.kwawannan.newyorkschools.view;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kwawannan.newyorkschools.R;
import com.kwawannan.newyorkschools.domain.NYCSchool;

import java.util.HashMap;


/**
 * Created by Kwaw Annan on 3/23/2018.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.mVH> {

    public Context ctx;

    public HashMap<String, String> schoolNameToSize = new HashMap<String, String>();

    public ResultsAdapter(NYCSchool[] c) {

        this.c = c;


        putSizeToSchoolInMap(c);


    }

    private void putSizeToSchoolInMap(NYCSchool[] c) {
        for (NYCSchool nycSchool : c) {
            schoolNameToSize.put(nycSchool.getSchoolName(), nycSchool.getTotalStudents());
        }
    }

    private String[] myData;
    private NYCSchool[] c;


    @Override
    public mVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.results, parent, false);
        ctx = parent.getContext();
        return new mVH(itemView);
    }

    @Override
    public void onBindViewHolder(mVH holder, int position) {

        Log.d("Ankit", c[position].getSchoolName());
        holder.mText.setText(c[position].getSchoolName());
        holder.distance.setText("Total Students : " + c[position].getTotalStudents());
        holder.website.setText("Website: " + c[position].getWebsite());
        holder.city.setText("City : " + c[position].getCity());
        Double d = Double.valueOf(c[position].getAttendanceRate());
        getRating(holder, d);

        final String schoolName = c[position].getSchoolName();
        holder.cLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, SATActivity.class);
                intent.putExtra("schoolName", schoolName);
                Bundle extras = new Bundle();
                extras.putSerializable("ratios", schoolNameToSize);
                intent.putExtras(extras);
                ctx.startActivity(intent);
            }
        });

    }

    private void getRating(mVH holder, Double d) {
        if (d != null) {

            if (d > .95) {
                holder.ratingBar.setRating(new Float(5.0));
            } else if (d > .85) {
                holder.ratingBar.setRating(new Float(4.0));
            } else if (d > .75) {
                holder.ratingBar.setRating(new Float(3.0));
            } else if (d > .65) {
                holder.ratingBar.setRating(new Float(2.0));
            } else if (d > .55) {
                holder.ratingBar.setRating(new Float(1.0));
            }

            Log.d("Double", " " + d);

        }
    }


    @Override
    public int getItemCount() {
        // return myData.length;s
        return c.length;
    }

    public class mVH extends RecyclerView.ViewHolder {

        public TextView mText;


        public RatingBar ratingBar;

        public TextView distance;

        public TextView website;

        public TextView city;

        public ConstraintLayout cLL;


        public mVH(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.schoolName);
            city = (TextView) itemView.findViewById(R.id.city);
            cLL = (ConstraintLayout) itemView.findViewById(R.id.parentLayout);
            website = (TextView) itemView.findViewById(R.id.website);
            ratingBar = (RatingBar) itemView.findViewById(R.id.restaurantRating);
            distance = (TextView) itemView.findViewById(R.id.distance);
            LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        }
    }


}
