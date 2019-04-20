package gabriellee.project.mvp_rxjava.database;

import java.util.List;
import java.util.concurrent.Callable;

import gabriellee.project.mvp_rxjava.model.User;
import io.reactivex.Observable;

public class UsersLocalRepoImpl implements UsersLocalRepo{

    private UsersDao usersDao;

    public UsersLocalRepoImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return usersDao.getAll();
            }
        });
    }


    @Override
    public void addUsers(List<User> users) {
        usersDao.insertAll(users);
    }
}
