package com.mmdet.jean.mvp.presenter;


import com.mmdet.jean.mvp.view.MvpView;

/**
 * @author jean
 * @date 2018/1/3 13:58
 * @description
 */

public interface MvpBasePresenter<V extends MvpView>{
    /**
     * 绑定view
     * @param view
     */
    public void attachView(V view);

    /**
     * 解除绑定View
     */
    public void detachView();

}
