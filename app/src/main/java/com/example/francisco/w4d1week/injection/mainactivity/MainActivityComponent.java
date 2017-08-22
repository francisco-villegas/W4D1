package com.example.francisco.w4d1week.injection.mainactivity;

import com.example.francisco.w4d1week.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by FRANCISCO on 21/08/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
