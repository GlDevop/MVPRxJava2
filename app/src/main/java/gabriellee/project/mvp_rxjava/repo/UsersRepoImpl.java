package gabriellee.project.mvp_rxjava.repo;

import java.util.List;

import gabriellee.project.mvp_rxjava.database.UsersLocalRepo;
import gabriellee.project.mvp_rxjava.model.User;
import gabriellee.project.mvp_rxjava.requests.UserRemoteRepo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UsersRepoImpl implements UsersRepo {

    UserRemoteRepo mUsersRemoteRepo;
    UsersLocalRepo mUsersLocalRepo;

    public UsersRepoImpl(UserRemoteRepo usersRemoteRepo, UsersLocalRepo usersLocalRepo) {
        mUsersRemoteRepo = usersRemoteRepo;
        mUsersLocalRepo = usersLocalRepo;
    }

    @Override
    public Observable<List<User>> getAllUsers() {

        return Observable.mergeDelayError(mUsersRemoteRepo.getAllUsers().doOnNext(new Consumer<List<User>>() {
            @Override
            public void accept(List<User> users) throws Exception {
                mUsersLocalRepo.addUsers(users);
            }
        })
        .subscribeOn(Schedulers.io()),
        mUsersLocalRepo.getAllUsers().subscribeOn(Schedulers.io()));
    }
}
