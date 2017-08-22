package com.example.francisco.w4d1week.view.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.francisco.w4d1week.R;
import com.example.francisco.w4d1week.injection.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements  MainActivityContract.View {

    private static final String TAG = "MainActivity";

    @BindView(R.id.tv)
    TextView tv;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerMainActivityComponent.create().inject(this);

        presenter.attachView(this);
        presenter.setContext(getApplicationContext());

    }

    @OnClick({R.id.btnSend, R.id.btnGet})
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnSend:
                presenter.savePerson("Jhon Doe");
                break;
            case R.id.btnGet:
                presenter.getPerson();
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {
        Log.d(TAG, "isPersonSaved: " + isSaved);
    }

    @Override
    public void sendPerson(String person) {
        Log.d(TAG, "sendPerson: " + person);
        tv.setText(person);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.removeView();
    }
}
