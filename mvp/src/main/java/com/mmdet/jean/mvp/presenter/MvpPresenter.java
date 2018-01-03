package com.mmdet.jean.mvp.presenter;

import android.content.Context;

import com.mmdet.jean.mvp.view.MvpView;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jean
 * @date 2018/1/3 10:00
 * @description 所有Presenter的基类
 */

public class MvpPresenter<V extends MvpView> implements MvpBasePresenter<V>{

    private V mView;
    private WeakReference<V> weakView;
    private WeakReference<Context> weakContext;

    public MvpPresenter(Context context){
        this.weakContext = new WeakReference<Context>(context);
    }
    public Context getContext() {
        return weakContext.get();
    }


    @Override
    public void attachView(V view) {
        this.weakView = new WeakReference<V>(view);
        MvpViewInvocationHandler mvpViewInvocationHandler = new MvpViewInvocationHandler(this.weakView.get());
        mView = (V)Proxy.newProxyInstance(
                view.getClass().getClassLoader(), view.getClass()
                        .getInterfaces(), mvpViewInvocationHandler);
    }


    /**
     * 获取view对象
     * @return 返回当前MvpView
     */
    public V getMvpView(){
        return mView;
    }


    @Override
    public void detachView() {
        if (this.weakView != null) {
            this.weakView.clear();
            this.weakView = null;
        }
    }

    private class MvpViewInvocationHandler implements InvocationHandler {

        private MvpView mvpView;
        public MvpViewInvocationHandler(MvpView mvpView) {
            this.mvpView = mvpView;
        }
        @Override
        public Object invoke(Object arg0, Method arg1, Object[] arg2)
                throws Throwable {
            if (isAttachView()) {
                return arg1.invoke(mvpView, arg2);
            }
            return null;
        }
    }
    /**
     * 用于检查View是否为空对象
     *
     * @return
     */
    public boolean isAttachView() {
        if (this.weakView != null && this.weakView.get() != null) {
            return true;
        }
        return false;
    }


}
