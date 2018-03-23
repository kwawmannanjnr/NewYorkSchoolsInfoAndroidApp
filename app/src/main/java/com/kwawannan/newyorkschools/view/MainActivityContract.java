package com.kwawannan.newyorkschools.view;

import com.kwawannan.newyorkschools.domain.NYCSchool;

/**
 * Contract for MVP layer
 */

public interface MainActivityContract {

    interface View {
        void updateSchoolList(NYCSchool[] schools);
    }

    interface Presenter {
        void addView(View view);

        void getNycSchools();


    }
}