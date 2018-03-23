package com.kwawannan.newyorkschools.view;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;
import com.kwawannan.newyorkschools.network.ErrorResponse;
import com.kwawannan.newyorkschools.network.NewServiceCallBack;
import com.kwawannan.newyorkschools.network.SchoolError;
import com.kwawannan.newyorkschools.network.SchoolServices;

import javax.inject.Inject;



/**
 * Created by Kwaw Annan on 3/23/2018.
 */

public class SATPresenter implements SATActivityContract.Presenter {

    public SchoolServices schoolServices;

    public SATActivityContract.View view;

    private static final String BASEURL_ENDPOINT = "https://data.cityofnewyork.us/resource/734v-jeq5.json";


    @Inject
    public SATPresenter(SchoolServices schoolServices) {
        this.schoolServices = schoolServices;
    }

    @Override
    public void addView(SATActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void getSatScores() {

        schoolServices.satScoreLookup(new NewServiceCallBack<SATScore[], ErrorResponse>() {
            @Override
            public void onResponse(NYCSchool[] response) {

            }

            @Override
            public void onResponse(SATScore[] response) {
                view.updateSATScores(response);
            }

            @Override
            public void onErrorResponse(ErrorResponse error) {

            }

            @Override
            public void onFail(SchoolError error) {

            }
        }, BASEURL_ENDPOINT);

    }
}
