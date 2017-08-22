package com.example.francisco.w4d1week.view.mainactivity;

import android.content.Context;

import com.example.francisco.w4d1week.BasePresenter;
import com.example.francisco.w4d1week.BaseView;

/**
 * Created by FRANCISCO on 21/08/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void isPersonSaved(boolean isSaved);
        void sendPerson(String person);

    }

    interface Presenter extends BasePresenter<View>{

        void savePerson(String person);
        String getPerson();
        void setContext(Context context);
        Context getContext();

    }
}
