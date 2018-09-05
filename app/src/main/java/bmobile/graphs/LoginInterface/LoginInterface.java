package bmobile.graphs.LoginInterface;

import bmobile.graphs.ErrorBody.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginInterface {
    //public static final String BASE_URL ="http://172.16.17.250/slimws/src/public/api/";
    public static final String BASE_URL ="http://201.140.108.18/serviciosBmobile/bmobileWS/api/";

    @Headers( "Content-Type: application/json")
    @POST("utils/obtenerDatosLogin")
    Call<User<Status>>login(@Body LoginBody loginBody);

}
