package com.mmdet.jean.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.mmdet.jean.mvp.presenter.MvpPresenter;
import com.mmdet.jean.mvp.proxy.fragment.FragmentMvpDelegate;
import com.mmdet.jean.mvp.proxy.fragment.FragmentMvpDelegateCallback;
import com.mmdet.jean.mvp.proxy.fragment.FragmentMvpDelegateImpl;
import com.mmdet.jean.mvp.view.MvpView;


public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>>
		extends Fragment implements FragmentMvpDelegateCallback<V, P>, MvpView {

	private P presenter;

	private FragmentMvpDelegate<V, P> activityMvpDelegate;

	protected FragmentMvpDelegate<V, P> getFragmentMvpDelegate() {
		if (this.activityMvpDelegate == null) {
			this.activityMvpDelegate = new FragmentMvpDelegateImpl<V, P>(this);
		}
		return this.activityMvpDelegate;
	}

	@Override
	public P getMvpPresenter() {
		return this.presenter;
	}

	@Override
	public void setMvpPresenter(P presenter) {
		this.presenter = presenter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V getMvpView() {
		return (V) this;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		getFragmentMvpDelegate().onAttach(context);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getFragmentMvpDelegate().onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getFragmentMvpDelegate().onActivityCreated(savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		getFragmentMvpDelegate().onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
		getFragmentMvpDelegate().onStart();
	}

	@Override
	public void onPause() {
		super.onPause();
		getFragmentMvpDelegate().onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		getFragmentMvpDelegate().onResume();
	}

	@Override
	public void onStop() {
		super.onStop();
		getFragmentMvpDelegate().onStop();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		getFragmentMvpDelegate().onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		getFragmentMvpDelegate().onDestroy();
	}

	@Override
	public void onDetach() {
		super.onDetach();
		getFragmentMvpDelegate().onDetach();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getFragmentMvpDelegate().onSaveInstanceState(outState);
	}

}
