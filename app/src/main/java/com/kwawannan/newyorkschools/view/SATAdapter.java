package com.kwawannan.newyorkschools.view;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kwawannan.newyorkschools.R;
import com.kwawannan.newyorkschools.domain.SATScore;

import java.util.HashMap;


/**
 * Created by Kwaw Annan on 3/23/2018.
 */

public class SATAdapter extends RecyclerView.Adapter<SATAdapter.mVH> {

    public Context ctx;

    private HashMap<String, String> schoolSizeRatios;

    public SATAdapter(SATScore[] c, HashMap<String, String> schoolSizeRatios) {

        this.c = c;
        this.schoolSizeRatios = schoolSizeRatios;
    }

    private String[] myData;
    private SATScore[] c;


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
        holder.distance.setText("Critical Reading : " + c[position].getSatCriticalReadingAvgScore());
        holder.website.setText("Math: " + c[position].getSatMathAvgScore());
        holder.city.setText("Writing : " + c[position].getSatWritingAvgScore());
        holder.attendance.setText("SAT Attendance Rating: ");


        getSatAttendanceRating(holder, c[position]);


        holder.cLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout ll = (ConstraintLayout) v;
                String s = ((TextView) ll.getChildAt(2)).getText().toString();

                Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getSatAttendanceRating(mVH holder, SATScore satScore) {
        int numOfSatTakers = 50;
    try {
        numOfSatTakers = Integer.valueOf(satScore.getNumOfSatTestTakers());
    }
    catch (Exception e) {

    }

        if (numOfSatTakers > 95) {
            holder.ratingBar.setRating(new Float(5.0));
        } else if (numOfSatTakers > 80.00) {
            holder.ratingBar.setRating(new Float(4.0));
        } else if (numOfSatTakers > 65) {
            holder.ratingBar.setRating(new Float(3.0));
        } else if (numOfSatTakers > 30) {
            holder.ratingBar.setRating(new Float(2.0));
        } else {
            holder.ratingBar.setRating(new Float(1.0));
        }
    }


    @Override
    public int getItemCount() {
        // return myData.length;s
        return c.length;
    }

    public class mVH extends RecyclerView.ViewHolder {

        public TextView mText;

        public TextView attendance;

        public RatingBar ratingBar;

        public TextView distance;

        public TextView website;

        public TextView city;

        public ConstraintLayout cLL;


        public mVH(View itemView) {
            super(itemView);
            attendance = (TextView) itemView.findViewById(R.id.Attendance);
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
