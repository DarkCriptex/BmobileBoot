package bmobile.graphs.LoginInterface;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserService {

    public static LoginInterface getUserEndpoints(){
        return  new Retrofit.Builder()
                .baseUrl(LoginInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LoginInterface.class);
    }


}
