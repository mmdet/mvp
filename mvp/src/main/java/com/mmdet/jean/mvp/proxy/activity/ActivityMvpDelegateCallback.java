package com.mmdet.jean.mvp.proxy.activity;


import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.proxy.MvpDelegateCallback;
import com.mmdet.jean.mvp.view.MvpView;

/**
 * @author jean
 * @date 2018/1/3 10:44
 * @description 第二重代理的目标接口，目标为mvp类的创建、绑定等
 */

public interface ActivityMvpDelegateCallback<V extends MvpView,P extends MvpPresenter<V>> extends MvpDelegateCallback<V,P> {
}
