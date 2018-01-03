package com.mmdet.jean.mvp.proxy.fragment;



import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.proxy.MvpDelegateCallback;
import com.mmdet.jean.mvp.view.MvpView;

/**
 * 扩展目标接口 针对不同的模块，目标接口有差异
 * 
 * @author jean
 *
 */
public interface FragmentMvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>>
		extends MvpDelegateCallback<V, P> {
	
}
