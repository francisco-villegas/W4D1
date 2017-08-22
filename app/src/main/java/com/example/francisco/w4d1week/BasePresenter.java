package com.example.francisco.w4d1week;

/**
 * Created by FRANCISCO on 21/08/2017.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void removeView();

}
