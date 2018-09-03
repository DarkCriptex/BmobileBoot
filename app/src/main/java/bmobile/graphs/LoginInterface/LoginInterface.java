package bmobile.graphs.LoginInterface;

import org.intellij.lang.annotations.JdkConstants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginInterface {
    //public static final String BASE_URL ="http://172.16.17.250/slimws/src/public/api/";
    public static final String BASE_URL ="http://201.140.108.18/serviciosBmobile/bmobileWS/api/";

    @Headers( "Content-Type: application/json")
    @POST("utils/obtenerDatosLogin")
    Call<User<Error>>login(@Body LoginBody loginBody);

}
