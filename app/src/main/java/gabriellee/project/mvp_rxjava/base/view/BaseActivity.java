package gabriellee.project.mvp_rxjava.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import gabriellee.project.mvp_rxjava.base.presenter.MvpPresenter;

public abstract class BaseActivity<T extends MvpPresenter> extends AppCompatActivity implements MvpView {

    private T presenter;

    protected
    @NonNull
    T getPresenter() {
        if (presenter == null)
            presenter = createPresenter();
        if (presenter == null)
            throw new IllegalStateException("createPresenter() implementation returns null!");
        return presenter;
    }

    protected abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onAttach(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().onDetach();
    }
}
