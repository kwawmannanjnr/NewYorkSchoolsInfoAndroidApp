package com.kwawannan.newyorkschools.injection;

/**
 * Created by Kwaw Annan on 3/23/2018.
 */

import com.kwawannan.newyorkschools.view.SATActivity;

import dagger.Component;

/**
 * Encapsulate Module
 */
@Component(modules = SATActivityPresenterModule.class)
public interface SATActivityComponent {


    void inject(SATActivity satActivity);


}