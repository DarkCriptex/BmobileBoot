package bmobile.graphs.UserConfigInterface;




import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserConfigInterface {

    @Headers( "Content-Type: application/json")
    @POST("iotdevice/guardarConfiguracionUsuario")
    Call<ResponseUserConfig> userConfig(@Body UserConfigBody userConfigBody);

}
