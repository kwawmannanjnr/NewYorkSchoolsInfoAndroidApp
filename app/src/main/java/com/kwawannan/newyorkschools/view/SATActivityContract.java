package com.kwawannan.newyorkschools.view;

import com.kwawannan.newyorkschools.domain.SATScore;



/**
 * Encapsulate MVP Contract for view and presenter
 */

public interface SATActivityContract {

    interface View {
        void updateSATScores(SATScore[] satScores);
    }

    interface Presenter {
        void addView(SATActivityContract.View view);

        void getSatScores();


    }
}
