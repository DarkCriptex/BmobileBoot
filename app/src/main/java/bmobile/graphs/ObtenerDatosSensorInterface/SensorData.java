package bmobile.graphs.ObtenerDatosSensorInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class SensorData <T>{
    @SerializedName("temperature_monitoring")
    @Expose
    private Double temperatureMonitoring;
    @SerializedName("hightemp_monitoring")
    @Expose
    private Integer hightempMonitoring;
    @SerializedName("lowtemp_monitoring")
    @Expose
    private Integer lowtempMonitoring;
    @SerializedName("humidity_monitoring")
    @Expose
    private Double humidityMonitoring;
    @SerializedName("highhum_monitoring")
    @Expose
    private Integer highhumMonitoring;
    @SerializedName("lowhum_monitoring")
    @Expose
    private Integer lowhumMonitoring;
    @Nullable
    T error ;
    public Double getTemperatureMonitoring() {
        return temperatureMonitoring;
    }

    public void setTemperatureMonitoring(Double temperatureMonitoring) {
        this.temperatureMonitoring = temperatureMonitoring;
    }

    public Integer getHightempMonitoring() {
        return hightempMonitoring;
    }

    public void setHightempMonitoring(Integer hightempMonitoring) {
        this.hightempMonitoring = hightempMonitoring;
    }

    public Integer getLowtempMonitoring() {
        return lowtempMonitoring;
    }

    public void setLowtempMonitoring(Integer lowtempMonitoring) {
        this.lowtempMonitoring = lowtempMonitoring;
    }

    public Double getHumidityMonitoring() {
        return humidityMonitoring;
    }

    public void setHumidityMonitoring(Double humidityMonitoring) {
        this.humidityMonitoring = humidityMonitoring;
    }

    public Integer getHighhumMonitoring() {
        return highhumMonitoring;
    }

    public void setHighhumMonitoring(Integer highhumMonitoring) {
        this.highhumMonitoring = highhumMonitoring;
    }

    public Integer getLowhumMonitoring() {
        return lowhumMonitoring;
    }

    public void setLowhumMonitoring(Integer lowhumMonitoring) {
        this.lowhumMonitoring = lowhumMonitoring;
    }

    @Nullable
    public T getError() {
        return error;
    }

    public void setError(@Nullable T error) {
        this.error = error;
    }
}
