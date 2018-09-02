package bmobile.graphs.ObtenerDatosSensorInterface;

import bmobile.graphs.LoginInterface.LoginInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetSensorDataService {
    public GetSensorDataService getSensorData(){
        return  new Retrofit.Builder()
                .baseUrl(LoginInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GetSensorDataService.class);
    }
}
