package bmobile.graphs.LoginInterface;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class User <T>{
    @SerializedName("id_user")
    @Expose
    @Nullable
    private int id_user;
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
    private T Error;
    @Nullable
    @Expose
    @SerializedName("proveedores")
    private ArrayList<Proveedores> proveedores;




    @Nullable
    public ArrayList<Proveedores> proveedores() {
        return proveedores;
    }

    public void setName_provider(@Nullable ArrayList<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }

    @Nullable
    public T getError() {
        return Error;
    }

    public void setError(@Nullable T Error) {
        this.Error = Error;
    }

    @Nullable
    public int getId_user() {
        return id_user;
    }

    public void setId_user(@Nullable Integer id_user) {
        this.id_user = id_user;
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
                "id_user=" + id_user +
                ", userClientIotdevice=" + userClientIotdevice +
                ", nameUser='" + nameUser + '\'' +
                ", lastnamesUser='" + lastnamesUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", nameLeveluser='" + nameLeveluser + '\'' +
                ", nameClient='" + nameClient + '\'' +
                ", error=" + Error +
                ", proveedores='"  + '\'' + proveedores +
                '}';
    }

    public User(@Nullable User user) {
        this.id_user = user.id_user;
        this.userClientIotdevice = user.userClientIotdevice;
        this.nameUser = user.nameUser;
        this.lastnamesUser = user.lastnamesUser;
        this.emailUser = user.emailUser;
        this.nameLeveluser = user.nameLeveluser;
        this.nameClient = user.nameClient;
        //this.Error  = (T) user.Error;

    }



}


