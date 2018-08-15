package bmobile.graphs.LoginInterface;

import org.intellij.lang.annotations.JdkConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {
    public static final String BASE_URL ="http://172.16.17.250/slimws/src/public/api/";

    @POST("utils/obtenerDatosLogin")
    Call<List<User>>login(@Body LoginBody loginBody);
}
