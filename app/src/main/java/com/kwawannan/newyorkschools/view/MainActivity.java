package com.kwawannan.newyorkschools.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.kwawannan.newyorkschools.R;
import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.injection.DaggerMainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    @Inject
    MainActivityPresenter presenter;

    RecyclerView recyclerView;

    ProgressBar progressBar;

    ResultsAdapter resultsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final GridLayoutManager mLayoutManager = new GridLayoutManager(this , 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        progressBar = (ProgressBar) findViewById(R.id.showSpinner);
        DaggerMainActivityComponent.create().inject(this);
        presenter.addView(this);
        presenter.getNycSchools();
    }

    @Override
    public void updateSchoolList(NYCSchool[] schools) {

        resultsAdapter = new ResultsAdapter(schools);
        recyclerView.setAdapter(resultsAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);


    }
}
