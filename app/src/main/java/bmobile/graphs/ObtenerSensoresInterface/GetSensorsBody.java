package bmobile.graphs.ObtenerSensoresInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class GetSensorsBody <T> {

    // se obtienen los sensores
    @SerializedName("status")
    @Expose
    @Nullable
    private T staus;
    @SerializedName("name_client")
    @Expose
    @Nullable
    private String nameClient;
    @SerializedName("id_location")
    @Expose
    @Nullable
    private Integer idLocation;
    @SerializedName("name_location")
    @Expose
    @Nullable
    private String nameLocation;
    @SerializedName("id_site")
    @Expose
    @Nullable
    private Integer idSite;
    @SerializedName("name_site")
    @Expose
    @Nullable
    private String nameSite;
    @SerializedName("sensores")
    @Expose
    @Nullable
    private ArrayList<Sensores> sensores = null;

    @Nullable
    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(@Nullable String nameClient) {
        this.nameClient = nameClient;
    }

    @Nullable
    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(@Nullable Integer idLocation) {
        this.idLocation = idLocation;
    }

    @Nullable
    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(@Nullable String nameLocation) {
        this.nameLocation = nameLocation;
    }

    @Nullable
    public Integer getIdSite() {
        return idSite;
    }

    public void setIdSite(@Nullable Integer idSite) {
        this.idSite = idSite;
    }

    @Nullable
    public String getNameSite() {
        return nameSite;
    }

    public void setNameSite(@Nullable String nameSite) {
        this.nameSite = nameSite;
    }

    @Nullable
    public ArrayList<Sensores> getSensores() {
        return sensores;
    }

    public void setSensores(@Nullable ArrayList<Sensores> sensores) {
        this.sensores = sensores;
    }

    @Nullable
    public T getStaus() {
        return staus;
    }

    public void setStaus(@Nullable T staus) {
        this.staus = staus;
    }

    @Override
    public String toString() {
        return "GetSensorsBody{" +
                "staus=" + staus +
                ", nameClient='" + nameClient + '\'' +
                ", idLocation=" + idLocation +
                ", nameLocation='" + nameLocation + '\'' +
                ", idSite=" + idSite +
                ", nameSite='" + nameSite + '\'' +
                ", sensores=" + sensores +
                '}';
    }
}
