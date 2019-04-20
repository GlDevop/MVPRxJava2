package gabriellee.project.mvp_rxjava.repo;

import java.util.List;

import gabriellee.project.mvp_rxjava.model.User;
import io.reactivex.Observable;

public interface UsersRepo {
    Observable<List<User>> getAllUsers();
}
