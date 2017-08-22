package com.example.francisco.w4d1week.view.mainactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.francisco.w4d1week.Dependency;
import com.example.francisco.w4d1week.Main;

/**
 * Created by FRANCISCO on 21/08/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainActivityPresenter";
    MainActivityContract.View view;

    Context context;

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void savePerson(String person) {
        Log.d(TAG, "savePerson: " + person);
        view.isPersonSaved(true);

        SharedPreferences sharedPreferences  = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("person", person);
        editor.commit();
    }

    @Override
    public String getPerson() {
        SharedPreferences sharedPreferences  = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        String person = sharedPreferences.getString("person","default");
        view.sendPerson(person);

        Dependency dependency = new Dependency();
        Main main = new Main(dependency);
        main.getManipulatedString(person);

        return person;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
