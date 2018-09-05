package bmobile.graphs.ObtenerSensoresInterface;


import bmobile.graphs.ErrorBody.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetSensorsInterface {
    @Headers( "Content-Type: application/json")
    @POST("iotdevice/obtenerSensores")
    Call<GetSensorsBody<Status>> getSensors(@Body SensorsBody sensorsBody);
}
