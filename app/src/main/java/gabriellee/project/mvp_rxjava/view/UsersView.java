package gabriellee.project.mvp_rxjava.view;

import java.util.List;

import gabriellee.project.mvp_rxjava.base.view.MvpView;
import gabriellee.project.mvp_rxjava.model.User;

public interface UsersView extends MvpView {

    void showUsers(List<User>users);
    void showLoading();
    void hideLoading();
    void showError(String error);

}
