package com.mmdet.jean.mvp.proxy.activity;

import android.os.Bundle;

import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.view.MvpView;

/**
 * @author jean
 * @date 2018/1/3 11:06
 * @description 第一重代理的目标接口，目标为监听生命activity的周期
 * @other 第一重代理下：activity为代理实现类，ActivityMvpDelegateImpl为目标接口类，本类则为接口
 * @other 具体的实现：activity里实例化ActivityMvpDelegateImpl，activity的每个生命周期下，调用ActivityMvpDelegateImpl的相关方法
 *        也就是说ActivityMvpDelegateImpl想要实现的生命周期监听，由activity代理来实现
 */

public interface ActivityMvpDelegate<V extends MvpView,P extends MvpPresenter<V>>{

    public void onCreate(Bundle savedInstanceState);

    public void onStart();

    public void onPause();

    public void onResume();

    public void onRestart();

    public void onStop();

    public void onDestroy();

    public void onContentChanged();

    public void onSaveInstanceState(Bundle outState);

    public void onAttachedToWindow();
}
