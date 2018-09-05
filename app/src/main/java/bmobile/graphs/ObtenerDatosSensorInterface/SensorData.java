package bmobile.graphs.ObtenerDatosSensorInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class SensorData <T>{
    @SerializedName("temperature_monitoring")
    @Expose
    @Nullable
    private Double temperatureMonitoring;
    @SerializedName("hightemp_monitoring")
    @Expose
    @Nullable
    private Double hightempMonitoring;
    @SerializedName("lowtemp_monitoring")
    @Expose
    @Nullable
    private Double lowtempMonitoring;
    @SerializedName("humidity_monitoring")
    @Expose
    @Nullable
    private Double humidityMonitoring;
    @SerializedName("highhum_monitoring")
    @Expose
    @Nullable
    private Double highhumMonitoring;
    @SerializedName("lowhum_monitoring")
    @Expose
    @Nullable
    private Double lowhumMonitoring;
    @SerializedName("consume_monitoring")
    @Expose
    @Nullable
    private Double consume_monitoring;
    @SerializedName("stream_monitoring")
    @Expose
    @Nullable
    private Double stream_monitoring;
    @Nullable
    @Expose
    @SerializedName("timestamp_monitoring")
    private String timestamp_monitoring;


    @Nullable
    public Double getTemperatureMonitoring() {
        return temperatureMonitoring;
    }

    public void setTemperatureMonitoring(@Nullable Double temperatureMonitoring) {
        this.temperatureMonitoring = temperatureMonitoring;
    }

    @Nullable
    public Double getHightempMonitoring() {
        return hightempMonitoring;
    }

    public void setHightempMonitoring(@Nullable Double hightempMonitoring) {
        this.hightempMonitoring = hightempMonitoring;
    }

    @Nullable
    public Double getLowtempMonitoring() {
        return lowtempMonitoring;
    }

    public void setLowtempMonitoring(@Nullable Double lowtempMonitoring) {
        this.lowtempMonitoring = lowtempMonitoring;
    }

    @Nullable
    public Double getHumidityMonitoring() {
        return humidityMonitoring;
    }

    public void setHumidityMonitoring(@Nullable Double humidityMonitoring) {
        this.humidityMonitoring = humidityMonitoring;
    }

    @Nullable
    public Double getHighhumMonitoring() {
        return highhumMonitoring;
    }

    public void setHighhumMonitoring(@Nullable Double highhumMonitoring) {
        this.highhumMonitoring = highhumMonitoring;
    }

    @Nullable
    public Double getLowhumMonitoring() {
        return lowhumMonitoring;
    }

    public void setLowhumMonitoring(@Nullable Double lowhumMonitoring) {
        this.lowhumMonitoring = lowhumMonitoring;
    }

    @Nullable
    public Double getConsume_monitoring() {
        return consume_monitoring;
    }

    public void setConsume_monitoring(@Nullable Double consume_monitoring) {
        this.consume_monitoring = consume_monitoring;
    }

    @Nullable
    public Double getStream_monitoring() {
        return stream_monitoring;
    }

    public void setStream_monitoring(@Nullable Double stream_monitoring) {
        this.stream_monitoring = stream_monitoring;
    }

    @Nullable
    public String getTimestamp_monitoring() {
        return timestamp_monitoring;
    }

    public void setTimestamp_monitoring(@Nullable String timestamp_monitoring) {
        this.timestamp_monitoring = timestamp_monitoring;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "temperatureMonitoring=" + temperatureMonitoring +
                ", hightempMonitoring=" + hightempMonitoring +
                ", lowtempMonitoring=" + lowtempMonitoring +
                ", humidityMonitoring=" + humidityMonitoring +
                ", highhumMonitoring=" + highhumMonitoring +
                ", lowhumMonitoring=" + lowhumMonitoring +
                ", consume_monitoring=" + consume_monitoring +
                ", stream_monitoring=" + stream_monitoring +
                ", timestamp_monitoring=" + timestamp_monitoring +
                '}';
    }
}
