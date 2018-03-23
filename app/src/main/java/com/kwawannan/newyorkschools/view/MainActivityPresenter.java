package com.kwawannan.newyorkschools.view;

import com.kwawannan.newyorkschools.domain.NYCSchool;
import com.kwawannan.newyorkschools.domain.SATScore;
import com.kwawannan.newyorkschools.network.ErrorResponse;
import com.kwawannan.newyorkschools.network.NewServiceCallBack;
import com.kwawannan.newyorkschools.network.SchoolError;
import com.kwawannan.newyorkschools.network.SchoolServices;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;



/**
 * Created by Kwaw Annan on 2/23/2018.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    public SchoolServices schoolServices;

    public MainActivityContract.View view;

    private static final String BASEURL_ENDPOINT = "https://data.cityofnewyork.us/resource/97mf-9njv.json";

    @Inject
    public MainActivityPresenter(SchoolServices schoolServices) {
        this.schoolServices = schoolServices;
    }

    @Override
    public void addView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void getNycSchools() {

        Map<String, String> queryParameters = new HashMap<String, String>();

        schoolServices.nycSchoolLookup(false, queryParameters, BASEURL_ENDPOINT, new NewServiceCallBack<NYCSchool[], ErrorResponse>() {
            @Override
            public void onResponse(NYCSchool[] response) {
                view.updateSchoolList(response);

            }

            public void onResponse(SATScore[] scores) {

            }

            @Override
            public void onErrorResponse(ErrorResponse error) {

            }

            @Override
            public void onFail(SchoolError error) {

            }
        });

    }
}
