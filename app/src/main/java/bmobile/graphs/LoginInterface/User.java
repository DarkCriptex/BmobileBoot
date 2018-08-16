package bmobile.graphs.LoginInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class User <T>{
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
    @SerializedName("name_provider")
    @Expose
    @Nullable
    private String nameProvider;
    @SerializedName("url_endpoints")
    @Expose
    @Nullable
    private String urlEndpoints;
    @SerializedName("awtenantcode_endpoints")
    @Expose
    @Nullable
    private String awtenantcodeEndpoints;
    @SerializedName("serverpassword_endpoints")
    @Expose
    @Nullable
    private String serverpasswordEndpoints;
    @SerializedName("serveruser_endpoints")
    @Expose
    @Nullable
    private String serveruserEndpoints;
    @SerializedName("Error")
    @Expose
    @Nullable

    private T error;
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
    @Nullable
    public void setIdUser(Integer idUser) {
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
    public String getNameProvider() {
        return nameProvider;
    }
    @Nullable
    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }
    @Nullable
    public String getUrlEndpoints() {
        return urlEndpoints;
    }
    @Nullable
    public void setUrlEndpoints(String urlEndpoints) {
        this.urlEndpoints = urlEndpoints;
    }
    @Nullable
    public String getAwtenantcodeEndpoints() {
        return awtenantcodeEndpoints;
    }
    @Nullable
    public void setAwtenantcodeEndpoints(String awtenantcodeEndpoints) {
        this.awtenantcodeEndpoints = awtenantcodeEndpoints;
    }
    @Nullable
    public String getServerpasswordEndpoints() {
        return serverpasswordEndpoints;
    }
    @Nullable
    public void setServerpasswordEndpoints(String serverpasswordEndpoints) {
        this.serverpasswordEndpoints = serverpasswordEndpoints;
    }
    @Nullable
    public String getServeruserEndpoints() {
        return serveruserEndpoints;
    }
    @Nullable
    public void setServeruserEndpoints(String serveruserEndpoints) {
        this.serveruserEndpoints = serveruserEndpoints;
    }

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
                ", nameProvider='" + nameProvider + '\'' +
                ", urlEndpoints='" + urlEndpoints + '\'' +
                ", awtenantcodeEndpoints='" + awtenantcodeEndpoints + '\'' +
                ", serverpasswordEndpoints='" + serverpasswordEndpoints + '\'' +
                ", serveruserEndpoints='" + serveruserEndpoints + '\'' +
                ", error=" + error +
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
        this.nameProvider = user.nameProvider;
        this.urlEndpoints = user.urlEndpoints;
        this.awtenantcodeEndpoints = user.awtenantcodeEndpoints;
        this.serverpasswordEndpoints = user.serverpasswordEndpoints;
        this.serveruserEndpoints = user.serveruserEndpoints;

    }
}


