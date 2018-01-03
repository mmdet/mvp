package com.mmdet.jean.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.proxy.activity.ActivityMvpDelegate;
import com.mmdet.jean.mvp.proxy.activity.ActivityMvpDelegateCallback;
import com.mmdet.jean.mvp.proxy.activity.ActivityMvpDelegateImpl;
import com.mmdet.jean.mvp.view.MvpView;

/**
 * @author jean
 * @date 2018/1/3 10:08
 * @description
 */

public abstract class MvpActivity<V extends MvpView,P extends MvpPresenter<V>> extends AppCompatActivity
        implements ActivityMvpDelegateCallback<V,P>,MvpView{

    private P presenter;
    private ActivityMvpDelegate<V, P> activityMvpDelegate;

    private ActivityMvpDelegate<V,P> getActivityMvpDelegate(){
        if(activityMvpDelegate == null){
            activityMvpDelegate = new ActivityMvpDelegateImpl<>(this);
        }
        return activityMvpDelegate;
    }

    @Override
    public P getMvpPresenter() {return this.presenter;}

    @Override
    public void setMvpPresenter(P presenter) {
        //presenter从哪儿创建的问题？
        //子Activity来创建presenter实例，由Activity的代理类调用Activity的该方法进行presenter的赋值
        this.presenter = presenter;
    }

    @Override
    public V getMvpView() {
        return (V)this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getActivityMvpDelegate().onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getActivityMvpDelegate().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getActivityMvpDelegate().onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getActivityMvpDelegate().onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getActivityMvpDelegate().onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getActivityMvpDelegate().onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getActivityMvpDelegate().onCreate(outState);
    }

}
