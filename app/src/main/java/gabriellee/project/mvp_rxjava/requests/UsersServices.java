package gabriellee.project.mvp_rxjava.requests;

import java.util.List;

import gabriellee.project.mvp_rxjava.model.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UsersServices {

    @GET("users")
    Observable<List<User>> getUsers();

}
