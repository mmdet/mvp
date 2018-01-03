package mmdet.com.myapp301;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.mmdet.jean.mvp.MvpActivity;
import com.mmdet.jean.mvp.presenter.MvpPresenter;

public class MainActivity extends MvpActivity<MainView,MainPresenter> implements MainView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainPresenter createMvpPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void loadSuccess(String result) {

        Log.i("res",result);
    }

    @Override
    public void empty() {
        Log.i("res","result is empty");
    }
}
