package bmobile.graphs.LoginInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User  {
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("user_client_iotdevice")
    @Expose
    private Integer userClientIotdevice;
    @SerializedName("name_user")
    @Expose
    private String nameUser;
    @SerializedName("lastnames_user")
    @Expose
    private String lastnamesUser;
    @SerializedName("email_user")
    @Expose
    private String emailUser;
    @SerializedName("name_leveluser")
    @Expose
    private String nameLeveluser;
    @SerializedName("name_client")
    @Expose
    private String nameClient;
    @SerializedName("name_provider")
    @Expose
    private String nameProvider;
    @SerializedName("url_endpoints")
    @Expose
    private String urlEndpoints;
    @SerializedName("awtenantcode_endpoints")
    @Expose
    private String awtenantcodeEndpoints;
    @SerializedName("serverpassword_endpoints")
    @Expose
    private String serverpasswordEndpoints;
    @SerializedName("serveruser_endpoints")
    @Expose
    private String serveruserEndpoints;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getUserClientIotdevice() {
        return userClientIotdevice;
    }

    public void setUserClientIotdevice(Integer userClientIotdevice) {
        this.userClientIotdevice = userClientIotdevice;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastnamesUser() {
        return lastnamesUser;
    }

    public void setLastnamesUser(String lastnamesUser) {
        this.lastnamesUser = lastnamesUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNameLeveluser() {
        return nameLeveluser;
    }

    public void setNameLeveluser(String nameLeveluser) {
        this.nameLeveluser = nameLeveluser;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    public String getUrlEndpoints() {
        return urlEndpoints;
    }

    public void setUrlEndpoints(String urlEndpoints) {
        this.urlEndpoints = urlEndpoints;
    }

    public String getAwtenantcodeEndpoints() {
        return awtenantcodeEndpoints;
    }

    public void setAwtenantcodeEndpoints(String awtenantcodeEndpoints) {
        this.awtenantcodeEndpoints = awtenantcodeEndpoints;
    }

    public String getServerpasswordEndpoints() {
        return serverpasswordEndpoints;
    }

    public void setServerpasswordEndpoints(String serverpasswordEndpoints) {
        this.serverpasswordEndpoints = serverpasswordEndpoints;
    }

    public String getServeruserEndpoints() {
        return serveruserEndpoints;
    }

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
                '}';
    }

    public User(Integer idUser, Integer userClientIotdevice, String nameUser, String lastnamesUser, String emailUser, String nameLeveluser, String nameClient, String nameProvider, String urlEndpoints, String awtenantcodeEndpoints, String serverpasswordEndpoints, String serveruserEndpoints) {
        this.idUser = idUser;
        this.userClientIotdevice = userClientIotdevice;
        this.nameUser = nameUser;
        this.lastnamesUser = lastnamesUser;
        this.emailUser = emailUser;
        this.nameLeveluser = nameLeveluser;
        this.nameClient = nameClient;
        this.nameProvider = nameProvider;
        this.urlEndpoints = urlEndpoints;
        this.awtenantcodeEndpoints = awtenantcodeEndpoints;
        this.serverpasswordEndpoints = serverpasswordEndpoints;
        this.serveruserEndpoints = serveruserEndpoints;
    }
}


