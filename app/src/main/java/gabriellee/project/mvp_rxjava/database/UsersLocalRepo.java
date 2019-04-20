package gabriellee.project.mvp_rxjava.database;

import java.util.List;

import gabriellee.project.mvp_rxjava.model.User;
import io.reactivex.Observable;

public interface UsersLocalRepo {
    Observable<List<User>> getAllUsers();
    void addUsers(List<User> users);
}
