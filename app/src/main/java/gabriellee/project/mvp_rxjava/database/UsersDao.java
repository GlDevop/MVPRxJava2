package gabriellee.project.mvp_rxjava.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import gabriellee.project.mvp_rxjava.model.User;

import static gabriellee.project.mvp_rxjava.database.DBConstant.USERS_TABLE_NAME;

@Dao
public interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> items);

    @Query("SELECT * FROM " + USERS_TABLE_NAME)
    List<User> getAll();

}
