package com.kwawannan.newyorkschools.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.kwawannan.newyorkschools.R;
import com.kwawannan.newyorkschools.domain.SATScore;
import com.kwawannan.newyorkschools.injection.DaggerSATActivityComponent;

import java.util.HashMap;

import javax.inject.Inject;


public class SATActivity extends AppCompatActivity implements SATActivityContract.View {

    @Inject
    SATPresenter presenter;

    RecyclerView recyclerView;

    ProgressBar progressBar;

    SATAdapter satAdapter;

    String schoolName;

    HashMap<String, String> schoolSizeRatios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Sat Scores");
        schoolSizeRatios = (HashMap<String, String>) getIntent().getExtras().getSerializable("ratios");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        progressBar = (ProgressBar) findViewById(R.id.showSpinner);
        DaggerSATActivityComponent.create().inject(this);
        presenter.addView(this);
        presenter.getSatScores();
    }


    @Override
    public void updateSATScores(SATScore[] satScores) {
        satAdapter = new SATAdapter(satScores, schoolSizeRatios);
        recyclerView.setAdapter(satAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}
