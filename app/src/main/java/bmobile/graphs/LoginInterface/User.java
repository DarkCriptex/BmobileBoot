package bmobile.graphs.LoginInterface;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User <T> implements Parcelable{
    @SerializedName("id_user")
    @Expose
    @Nullable
    private Integer idUser;
    @SerializedName("user_client_iotdevice")
    @Expose
    @Nullable
    private Integer userClientIotdevice;
    @SerializedName("name_user")
    @Expose
    @Nullable
    private String nameUser;
    @SerializedName("lastnames_user")
    @Expose
    @Nullable
    private String lastnamesUser;
    @SerializedName("email_user")
    @Expose
    @Nullable
    private String emailUser;
    @SerializedName("name_leveluser")
    @Expose
    @Nullable
    private String nameLeveluser;
    @SerializedName("name_client")
    @Expose
    @Nullable
    private String nameClient;

    @SerializedName("Error")
    @Expose
    @Nullable
    private T error;
    @Nullable
    @Expose
    @SerializedName("proveedores")
    private ArrayList<Proveedores> proveedores;

    protected User(Parcel in) {
        if (in.readByte() == 0) {
            idUser = null;
        } else {
            idUser = in.readInt();
        }
        if (in.readByte() == 0) {
            userClientIotdevice = null;
        } else {
            userClientIotdevice = in.readInt();
        }
        nameUser = in.readString();
        lastnamesUser = in.readString();
        emailUser = in.readString();
        nameLeveluser = in.readString();
        nameClient = in.readString();
        proveedores = in.createTypedArrayList(Proveedores.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Nullable
    public ArrayList<Proveedores> proveedores() {
        return proveedores;
    }

    public void setName_provider(@Nullable ArrayList<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }

    @Nullable
    public T getError() {
        return error;
    }

    public void setError(@Nullable T error) {
        this.error = error;
    }

    @Nullable
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(@Nullable Integer idUser) {
        this.idUser = idUser;
    }
    @Nullable
    public Integer getUserClientIotdevice() {
        return userClientIotdevice;
    }
    @Nullable
    public void setUserClientIotdevice(Integer userClientIotdevice) {
        this.userClientIotdevice = userClientIotdevice;
    }
    @Nullable
    public String getNameUser() {
        return nameUser;
    }
    @Nullable
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    @Nullable
    public String getLastnamesUser() {
        return lastnamesUser;
    }
    @Nullable
    public void setLastnamesUser(String lastnamesUser) {
        this.lastnamesUser = lastnamesUser;
    }
    @Nullable
    public String getEmailUser() {
        return emailUser;
    }
    @Nullable
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    @Nullable
    public String getNameLeveluser() {
        return nameLeveluser;
    }
    @Nullable
    public void setNameLeveluser(String nameLeveluser) {
        this.nameLeveluser = nameLeveluser;
    }
    @Nullable
    public String getNameClient() {
        return nameClient;
    }
    @Nullable
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
    @Nullable


    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", userClientIotdevice=" + userClientIotdevice +
                ", nameUser='" + nameUser + '\'' +
                ", lastnamesUser='" + lastnamesUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", nameLeveluser='" + nameLeveluser + '\'' +
                ", nameClient='" + nameClient + '\'' +
                ", error=" + error +
                ", proveedores='"  + '\'' + proveedores +
                '}';
    }

    public User(@Nullable User user) {
        this.idUser = user.idUser;
        this.userClientIotdevice = user.userClientIotdevice;
        this.nameUser = user.nameUser;
        this.lastnamesUser = user.lastnamesUser;
        this.emailUser = user.emailUser;
        this.nameLeveluser = user.nameLeveluser;
        this.nameClient = user.nameClient;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idUser);
        dest.writeInt(userClientIotdevice);
        dest.writeString(nameUser);
        dest.writeString(lastnamesUser);
        dest.writeString(emailUser);
        dest.writeString(nameLeveluser);
        dest.writeString(nameClient);
    }
}


