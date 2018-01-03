package com.mmdet.jean.mvp.proxy;


import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.view.MvpView;

/**
 * @author jean
 * @date 2018/1/3 10:30
 * @description  该类是具体的代理对象，代理 mvpActivity类实现mvp的绑定、创建、解绑等
 */

public class MvpDelegateCallbackProxy<V extends MvpView, P extends MvpPresenter<V>> implements MvpDelegateCallback<V,P> {


    private  MvpDelegateCallback<V,P> mvpDelegateCallback;
    public MvpDelegateCallbackProxy(MvpDelegateCallback<V,P> mvpDelegateCallback){
        this.mvpDelegateCallback = mvpDelegateCallback;
    }

    @Override
    public P createMvpPresenter() {
        P presenter = mvpDelegateCallback.getMvpPresenter();
        if(presenter == null){
            presenter = mvpDelegateCallback.createMvpPresenter();
        }
        if(presenter == null){
            throw new NullPointerException("presenter is not null");
        }
        // 绑定
        mvpDelegateCallback.setMvpPresenter(presenter);

        return getMvpPresenter();
    }

    @Override
    public P getMvpPresenter() {
        P presenter = mvpDelegateCallback.getMvpPresenter();
        if (presenter == null) {
            // 抛异常
            throw new NullPointerException("Presenter is not null!");
        }
        return presenter;
    }

    @Override
    public void setMvpPresenter(P presenter) {
        mvpDelegateCallback.setMvpPresenter(presenter);
    }

    @Override
    public V getMvpView() {
        return mvpDelegateCallback.getMvpView();
    }
    public void attachView() {
        getMvpPresenter().attachView(getMvpView());
    }

    public void detachView() {
        getMvpPresenter().detachView();
    }

}
