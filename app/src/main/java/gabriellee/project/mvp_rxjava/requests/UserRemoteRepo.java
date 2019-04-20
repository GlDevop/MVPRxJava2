package gabriellee.project.mvp_rxjava.requests;

import java.util.List;

import gabriellee.project.mvp_rxjava.model.User;
import io.reactivex.Observable;

public interface UserRemoteRepo {

    Observable<List<User>> getAllUsers();
}
