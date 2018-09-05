package bmobile.graphs.ObtenerDatosSensorInterface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bmobile.graphs.LoginInterface.LoginInterface;
import bmobile.graphs.ObtenerSensoresInterface.GetSensorsInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetSensorDataService {
    public static GetSensorDataInterface getSensorData(){

        return  new Retrofit.Builder()
                .baseUrl(LoginInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GetSensorDataInterface.class);
    }
}
