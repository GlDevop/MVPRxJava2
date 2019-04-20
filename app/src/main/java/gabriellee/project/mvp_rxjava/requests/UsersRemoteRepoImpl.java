package gabriellee.project.mvp_rxjava.requests;

import java.util.List;

import gabriellee.project.mvp_rxjava.base.BaseRemote;
import gabriellee.project.mvp_rxjava.model.User;
import io.reactivex.Observable;

public class UsersRemoteRepoImpl extends BaseRemote implements UserRemoteRepo{

    public static final String BASE_URL = "http://demo7261611.mockable.io/";

    @Override
    public Observable<List<User>> getAllUsers() {
        return create(UsersServices.class, BASE_URL).getUsers();
    }
}
