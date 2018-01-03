package com.mmdet.jean.mvp.proxy;


import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.view.MvpView;

/**
 * @author jean
 * @date 2018/1/3 10:26
 * @description
 */

public interface MvpDelegateCallback<V extends MvpView,P extends MvpPresenter<V>> {

    public P createMvpPresenter();

    public P getMvpPresenter();

    public void setMvpPresenter(P presenter);

    public V getMvpView();
}
