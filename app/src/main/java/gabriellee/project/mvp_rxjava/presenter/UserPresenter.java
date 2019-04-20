package gabriellee.project.mvp_rxjava.presenter;

import gabriellee.project.mvp_rxjava.base.presenter.BasePresenter;
import gabriellee.project.mvp_rxjava.view.UsersView;

public abstract class UserPresenter extends BasePresenter<UsersView> {

    public abstract void getUsers();

}
