package com.kwawannan.newyorkschools.injection;

/**
 * Created by Kwaw Annan on 3/23/2018.
 */

import com.kwawannan.newyorkschools.view.MainActivity;

import dagger.Component;

/**
 * Encapsulate Module
 */
@Component(modules = MainActivityPresenterModule.class)
public interface MainActivityComponent {


    void inject(MainActivity mainActivity);


}