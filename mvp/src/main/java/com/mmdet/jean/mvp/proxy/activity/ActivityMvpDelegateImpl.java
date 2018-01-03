package com.mmdet.jean.mvp.proxy.activity;

import android.os.Bundle;

import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.proxy.MvpDelegateCallbackProxy;
import com.mmdet.jean.mvp.view.MvpView;


/**
 * @author jean
 * @date 2018/1/3 11:16
 * @description
 */

public class ActivityMvpDelegateImpl<V extends MvpView,P extends MvpPresenter<V>> implements ActivityMvpDelegate<V,P> {


    private MvpDelegateCallbackProxy mvpDelegateCallbackProxy;
    // 具体的目标接口实现类，需要持有创建Mvp实例
    private ActivityMvpDelegateCallback<V, P> delegateCallback;
    public ActivityMvpDelegateImpl(ActivityMvpDelegateCallback<V,P> mvpDelegateCallback){
        this.delegateCallback = mvpDelegateCallback;
        if(mvpDelegateCallbackProxy == null){
            mvpDelegateCallbackProxy = new MvpDelegateCallbackProxy(mvpDelegateCallback);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mvpDelegateCallbackProxy.createMvpPresenter();
        mvpDelegateCallbackProxy.attachView();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        mvpDelegateCallbackProxy.detachView();
    }

    @Override
    public void onContentChanged() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onAttachedToWindow() {

    }


}
