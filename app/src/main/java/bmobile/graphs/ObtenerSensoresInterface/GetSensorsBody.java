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
    private T error;
    @SerializedName("name_client")
    @Expose
    private String nameClient;
    @SerializedName("id_location")
    @Expose
    private Integer idLocation;
    @SerializedName("name_location")
    @Expose
    private String nameLocation;
    @SerializedName("id_site")
    @Expose
    private Integer idSite;
    @SerializedName("name_site")
    @Expose
    private String nameSite;
    @SerializedName("sensores")
    @Expose
    private ArrayList<Sensores> sensores = null;

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public Integer getIdSite() {
        return idSite;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    public String getNameSite() {
        return nameSite;
    }

    public void setNameSite(String nameSite) {
        this.nameSite = nameSite;
    }

    public ArrayList<Sensores> getSensores() {
        return sensores;
    }

    public void setSensores(ArrayList<Sensores> sensores) {
        this.sensores = sensores;
    }

    @Nullable
    public T getError() {
        return error;
    }

    public void setError(@Nullable T error) {
        this.error = error;
    }
}
