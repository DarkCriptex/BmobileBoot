package bmobile.graphs.UserConfigInterface;

import bmobile.graphs.LoginInterface.LoginInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserConfigService {

    public static UserConfigInterface saveUserConfig(){
        return  new Retrofit.Builder()
                .baseUrl(LoginInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserConfigInterface.class);
    }
}
