package com.kwawannan.newyorkschools.injection;

/**
 * Created by agoel on 2/12/2018.
 */

import com.kwawannan.newyorkschools.network.NetworkManager;
import com.kwawannan.newyorkschools.network.SchoolNetwork;
import com.kwawannan.newyorkschools.network.SchoolNetworkManager;
import com.kwawannan.newyorkschools.network.SchoolNetworkService;
import com.kwawannan.newyorkschools.network.SchoolServices;
import com.kwawannan.newyorkschools.network.SchoolServicesImpl;
import com.kwawannan.newyorkschools.view.MainActivityContract;
import com.kwawannan.newyorkschools.view.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Encapsulate Dependencies
 */
@Module
public class MainActivityPresenterModule {

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