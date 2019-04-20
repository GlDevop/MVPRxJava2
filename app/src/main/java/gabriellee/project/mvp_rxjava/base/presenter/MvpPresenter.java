package gabriellee.project.mvp_rxjava.base.presenter;

import gabriellee.project.mvp_rxjava.base.view.MvpView;

public interface MvpPresenter<P extends MvpView> {
    /**
     * Called when an {@code MvpView} is attached to this presenter.
     *
     * @param view The attached {@code MvpView}
     */
    void onAttach(P view);

    /**
     * Called when the view is resumed according to Android components
     * NOTE: this method will only be called for presenters that override it.
     */
    void onResume();

    /**
     * Called when an {@code MvpView} is detached from this presenter.
     */
    void onDetach();

}
