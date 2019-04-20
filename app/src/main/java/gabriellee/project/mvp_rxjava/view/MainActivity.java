package gabriellee.project.mvp_rxjava.view;

import android.arch.persistence.room.Room;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import gabriellee.project.mvp_rxjava.R;
import gabriellee.project.mvp_rxjava.adapter.UserRecyclerViewAdapter;
import gabriellee.project.mvp_rxjava.base.view.BaseActivity;
import gabriellee.project.mvp_rxjava.database.DBConstant;
import gabriellee.project.mvp_rxjava.database.LocalDB;
import gabriellee.project.mvp_rxjava.database.UsersLocalRepo;
import gabriellee.project.mvp_rxjava.database.UsersLocalRepoImpl;
import gabriellee.project.mvp_rxjava.model.User;
import gabriellee.project.mvp_rxjava.presenter.UserPresenter;
import gabriellee.project.mvp_rxjava.presenter.UsersPresenterImpl;
import gabriellee.project.mvp_rxjava.repo.UsersRepo;
import gabriellee.project.mvp_rxjava.repo.UsersRepoImpl;
import gabriellee.project.mvp_rxjava.requests.UserRemoteRepo;
import gabriellee.project.mvp_rxjava.requests.UsersRemoteRepoImpl;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity<UserPresenter> implements UsersView {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerViewUser;

    private UserRecyclerViewAdapter userRecyclerViewAdapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected UserPresenter createPresenter() {

        UserRemoteRepo remoteUsersRepo = new UsersRemoteRepoImpl();
        LocalDB localDB = Room.databaseBuilder(getApplicationContext(), LocalDB.class, DBConstant.DB_NAME).build();


        UsersLocalRepo localUsersRepo = new UsersLocalRepoImpl(localDB.usersDao());

        UsersRepo usersRepo = new UsersRepoImpl(remoteUsersRepo, localUsersRepo);

        return new UsersPresenterImpl(usersRepo, AndroidSchedulers.mainThread());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.recycler_view_user);

        //getPresenter().getUsers();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewUser.removeAllViewsInLayout();
                getPresenter().getUsers();
            }
        });
    }

    @Override
    public void showUsers(List<User> users) {
        Log.d(TAG, "showUsers() returned: " + users.size());
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewUser.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(layoutManager);

        //add divider for spacing
        recyclerViewUser.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));

        // specify an adapter (see also next example)
        userRecyclerViewAdapter = new UserRecyclerViewAdapter(getApplicationContext(), users);
        recyclerViewUser.setAdapter(userRecyclerViewAdapter);
    }

    @Override
    public void showLoading() {

        Log.d(TAG, "showLoading() returned: ");

    }

    @Override
    public void hideLoading() {
        Log.d(TAG, "hideLoading() returned: ");
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError() returned: " + error);
    }
}