package bmobile.graphs.UserConfigInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class ResponseUserConfig <T>{
    @SerializedName("id_endpoints")
    @Expose
    private Integer idEndpoints;
    @SerializedName("error")
    @Expose
    @Nullable
    private T error;
    @Nullable
    public T getError() {
        return error;
    }

    public void setError(@Nullable T error) {
        this.error = error;
    }


    public Integer getIdEndpoints() {
        return idEndpoints;
    }

    public void setIdEndpoints(Integer idEndpoints) {
        this.idEndpoints = idEndpoints;
    }

    @Override
    public String toString() {
        return "ResponseUserConfig{" +
                "idEndpoints=" + idEndpoints +
                ", error=" + error +
                '}';
    }
}
