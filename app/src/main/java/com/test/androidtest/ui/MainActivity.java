package com.test.androidtest.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.test.androidtest.MyApplication;
import com.test.androidtest.R;
import com.test.androidtest.Service.DataService;
import com.test.androidtest.adapter.FruitAdapter;
import com.test.androidtest.api.FruitService;
import com.test.androidtest.presenter.FruitPresenter;
import com.test.androidtest.presenter.FruitView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class MainActivity extends AppCompatActivity implements FruitView {
    @Inject
    FruitService fruitService;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.fruit_recycler_view)
    RecyclerView mFruitRecyclerView;

    private static final String TAG = MainActivity.class.getSimpleName();
    private FruitAdapter mFruitAdapter;
    private FruitPresenter presenter;
    private DataService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFruitAdapter = new FruitAdapter();
        service = new DataService(mFruitAdapter);
        presenter = new FruitPresenter(this, service);
        startInjectors();
        configViews();
        mFruitRecyclerView.setAdapter(mFruitAdapter);
        presenter.getDataForAdapter();
    }

    private void startInjectors() {
        ((MyApplication) getApplication()).getNetComponent().inject(service);
        ButterKnife.bind(this);
    }

    private void configViews() {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        } else {
            mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        }
        mToolbar.setTitle("Android Test");
        setSupportActionBar(mToolbar);

        mFruitRecyclerView.setHasFixedSize(true);
        mFruitRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mFruitRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mFruitRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
