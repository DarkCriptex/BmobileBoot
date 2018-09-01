package bmobile.graphs.ObtenerSensoresInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sensores {

    @SerializedName("id_device")
    @Expose
    private Integer idDevice;
    @SerializedName("name_device")
    @Expose
    private String nameDevice;
    @SerializedName("uniquenumber_device")
    @Expose
    private String uniquenumberDevice;
    @SerializedName("device_type_iotdevice")
    @Expose
    private Integer deviceTypeIotdevice;

    public Integer getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Integer idDevice) {
        this.idDevice = idDevice;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getUniquenumberDevice() {
        return uniquenumberDevice;
    }

    public void setUniquenumberDevice(String uniquenumberDevice) {
        this.uniquenumberDevice = uniquenumberDevice;
    }

    public Integer getDeviceTypeIotdevice() {
        return deviceTypeIotdevice;
    }

    public void setDeviceTypeIotdevice(Integer deviceTypeIotdevice) {
        this.deviceTypeIotdevice = deviceTypeIotdevice;
    }

}
