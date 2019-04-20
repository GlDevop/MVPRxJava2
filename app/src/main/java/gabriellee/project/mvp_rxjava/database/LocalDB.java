package gabriellee.project.mvp_rxjava.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import gabriellee.project.mvp_rxjava.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class LocalDB extends RoomDatabase {

    public abstract UsersDao usersDao();

}
