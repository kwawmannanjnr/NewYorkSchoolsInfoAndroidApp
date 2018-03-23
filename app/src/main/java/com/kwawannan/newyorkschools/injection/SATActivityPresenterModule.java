package com.kwawannan.newyorkschools.injection;

import com.kwawannan.newyorkschools.network.NetworkManager;
import com.kwawannan.newyorkschools.network.SchoolNetwork;
import com.kwawannan.newyorkschools.network.SchoolNetworkManager;
import com.kwawannan.newyorkschools.network.SchoolNetworkService;
import com.kwawannan.newyorkschools.network.SchoolServices;
import com.kwawannan.newyorkschools.network.SchoolServicesImpl;
import com.kwawannan.newyorkschools.view.MainActivityPresenter;
import com.kwawannan.newyorkschools.view.MainActivityContract;

import dagger.Module;
import dagger.Provides;



/**
 * Created by Kwaw Annan on 3/23/2018.
 */
@Module
public class SATActivityPresenterModule {

    @Provides
    public NetworkManager provideISSNetworkManager(SchoolNetworkManager networkManager) {

        return networkManager;
    }

    @Provides
    public MainActivityContract.Presenter provideMainActivityPresenter(
            MainActivityPresenter presenter) {
        return presenter;
    }

    @Provides
    public SchoolNetwork provideISSNetworkService(SchoolNetworkService schoolNetworkService) {
        return schoolNetworkService;
    }

    @Provides
    public SchoolServices provideISSServices(SchoolServicesImpl schoolServices) {
        return schoolServices;
    }
}
