package bmobile.graphs.ObtenerSensoresInterface;

import bmobile.graphs.LoginInterface.LoginInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SensorsService {

    public static GetSensorsInterface getSensors(){
        return  new Retrofit.Builder()
                .baseUrl(LoginInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GetSensorsInterface.class);
    }
}
