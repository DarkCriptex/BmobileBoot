package bmobile.graphs.ObtenerDatosSensorInterface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetSensorDataInterface {

    @GET("iotdevice/obtenerDatosSensor/{uniquenumber_device}/{id_device}")
    Call<SensorData<bmobile.graphs.ErrorBody.Error>> getSensorData(@Path("uniquenumber_device") String uniquenumber_device, @Path("id_device") int id_device);
}
