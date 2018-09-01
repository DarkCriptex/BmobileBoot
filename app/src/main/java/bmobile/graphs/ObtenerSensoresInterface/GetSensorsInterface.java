package bmobile.graphs.ObtenerSensoresInterface;


import bmobile.graphs.ErrorBody.Error;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetSensorsInterface {
    @Headers( "Content-Type: application/json")
    @POST("iotdevice/obtenerSensores")
    Call<GetSensorsBody<Error>> getSensors(@Body SensorsBody sensorsBody);
}
