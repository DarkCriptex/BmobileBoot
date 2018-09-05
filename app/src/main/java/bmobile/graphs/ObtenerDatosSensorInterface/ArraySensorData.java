package bmobile.graphs.ObtenerDatosSensorInterface;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArraySensorData <T> {
    @SerializedName("datosSensor")
    @Expose
    @Nullable
    private ArrayList<SensorData> sensorData;
    @Nullable
    @Expose
    T status ;

    @Nullable
    public ArrayList<SensorData> getSensorData() {
        return sensorData;
    }

    public void setSensorData(@Nullable ArrayList<SensorData> sensorData) {
        this.sensorData = sensorData;
    }

    public void setStatus(@org.jetbrains.annotations.Nullable T status) {
        this.status = status;
    }

    @Nullable
    public T getStatus() {
        return status;
    }
}
