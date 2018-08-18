package bmobile.graphs.UserConfigInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUserConfig {
    @SerializedName("id_endpoints")
    @Expose
    private Integer idEndpoints;

    public Integer getIdEndpoints() {
        return idEndpoints;
    }

    public void setIdEndpoints(Integer idEndpoints) {
        this.idEndpoints = idEndpoints;
    }
}
