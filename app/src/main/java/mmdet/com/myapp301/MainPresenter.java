package mmdet.com.myapp301;

import android.content.Context;

import com.mmdet.jean.mvp.presenter.MvpPresenter;

/**
 * @author jean
 * @date 2018/1/3 15:07
 * @description
 */

public class MainPresenter extends MvpPresenter<MainView> {

    MainModle mainModle;
    public MainPresenter(Context context) {
        super(context);
        this.mainModle = new MainModle();
    }

    public void test(){
        String res = mainModle.test();
        if(res == null){
           getMvpView().empty();
        }else{
            getMvpView().loadSuccess(res);
        }

    }


}
