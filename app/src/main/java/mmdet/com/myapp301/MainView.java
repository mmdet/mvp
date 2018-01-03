package mmdet.com.myapp301;

import com.mmdet.jean.mvp.view.MvpView;

/**
 * @author jean
 * @date 2018/1/3 15:06
 * @description
 */

public interface MainView extends MvpView {

    void loadSuccess(String result);

    void empty();
}
