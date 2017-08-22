package com.example.francisco.w4d1week.injection.mainactivity;

import com.example.francisco.w4d1week.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by FRANCISCO on 21/08/2017.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter provideMainActivityPresenter(){

        return new MainActivityPresenter();
    }

//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Provides
//    FingerprintManager getFingerprintManager(){
//        return new FingerprintManager();
//    }
}
