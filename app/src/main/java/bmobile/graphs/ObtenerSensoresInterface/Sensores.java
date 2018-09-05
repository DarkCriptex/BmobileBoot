package bmobile.graphs.ObtenerSensoresInterface;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sensores  implements Parcelable {

    @SerializedName("id_device")
    @Expose
    @Nullable
    private  int id_device;
    @SerializedName("name_device")
    @Expose
    @Nullable
    private String name_device;
    @SerializedName("uniquenumber_device")
    @Expose
    @Nullable
    private String uniquenumber_device;
    @SerializedName("device_type_iotdevice")
    @Expose
    @Nullable
    private int device_type_iotdevice;

    protected Sensores(Parcel in) {
        id_device = in.readInt();
        device_type_iotdevice = in.readInt();
        name_device = in.readString();
        uniquenumber_device = in.readString();
}

    public static final Creator<Sensores> CREATOR = new Creator<Sensores>() {
        @Override
        public Sensores createFromParcel(Parcel in) {
            return new Sensores(in);
        }

        @Override
        public Sensores[] newArray(int size) {
            return new Sensores[size];
        }
    };

    @Nullable
    public Integer getIdDevice() {
        return id_device;
    }

    public void setIdDevice(@Nullable int idDevice) {
        this.id_device = idDevice;
    }

    @Nullable
    public String getNameDevice() {
        return name_device;
    }

    public void setNameDevice(@Nullable String nameDevice) {
        this.name_device = nameDevice;
    }

    @Nullable
    public String getUniquenumberDevice() {
        return uniquenumber_device;
    }

    public void setUniquenumberDevice(@Nullable String uniquenumberDevice) {
        this.uniquenumber_device = uniquenumberDevice;
    }

    @Nullable
    public int getDeviceTypeIotdevice() {
        return device_type_iotdevice;
    }

    public void setDeviceTypeIotdevice(@Nullable int deviceTypeIotdevice) {
        this.device_type_iotdevice = deviceTypeIotdevice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id_device);
            dest.writeInt(device_type_iotdevice);
            dest.writeString(name_device);
            dest.writeString(uniquenumber_device);
    }

    @Override
    public String toString() {
        return "Sensores{" +
                "id_device=" + id_device +
                ", name_device='" + name_device + '\'' +
                ", uniquenumber_device='" + uniquenumber_device + '\'' +
                ", device_type_iotdevice=" + device_type_iotdevice +
                '}';
    }
}
