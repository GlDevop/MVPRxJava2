package gabriellee.project.mvp_rxjava.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import gabriellee.project.mvp_rxjava.database.DBConstant;

@Entity(tableName = DBConstant.USERS_TABLE_NAME)
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstant.USER_ID)
    private int id;

    @SerializedName("first_name")
    @ColumnInfo(name = DBConstant.USER_FIRST_NAME)
    private String firstname;

    @SerializedName("last_name")
    @ColumnInfo(name = DBConstant.USER_LAST_NAME)
    private String lastName;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
