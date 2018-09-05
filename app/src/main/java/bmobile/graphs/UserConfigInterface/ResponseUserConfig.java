package bmobile.graphs.UserConfigInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class ResponseUserConfig <T>{
    @SerializedName("id_endpoints")
    @Expose
    private Integer idEndpoints;
    @SerializedName("status")
    @Expose
    @Nullable
    private T status;

    public Integer getIdEndpoints() {
        return idEndpoints;
    }

    public void setIdEndpoints(Integer idEndpoints) {
        this.idEndpoints = idEndpoints;
    }

    @Nullable
    public T getStatus() {
        return status;
    }

    public void setStatus(@Nullable T status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseUserConfig{" +
                "idEndpoints=" + idEndpoints +
                ", error=" + status +
                '}';
    }
}
