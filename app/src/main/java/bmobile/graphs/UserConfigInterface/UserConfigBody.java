package bmobile.graphs.UserConfigInterface;

public class UserConfigBody {

   private String url_endpoints ;
   private String awtenantcode_endpoints;
   private String serveruser_endpoints;
   private String serverpassword_endpoints;
   private int endpoints_user_iotdevice;
   private int endpoints_provider_iotdevice;


    public String getUrl_endpoints() {
        return url_endpoints;
    }

    public void setUrl_endpoints(String url_endpoints) {
        this.url_endpoints = url_endpoints;
    }

    public String getAwtenantcode_endpoints() {
        return awtenantcode_endpoints;
    }

    public void setAwtenantcode_endpoints(String awtenantcode_endpoints) {
        this.awtenantcode_endpoints = awtenantcode_endpoints;
    }

    public String getServeruser_endpoints() {
        return serveruser_endpoints;
    }

    public void setServeruser_endpoints(String serveruser_endpoints) {
        this.serveruser_endpoints = serveruser_endpoints;
    }

    public String getServerpassword_endpoints() {
        return serverpassword_endpoints;
    }

    public void setServerpassword_endpoints(String serverpassword_endpoints) {
        this.serverpassword_endpoints = serverpassword_endpoints;
    }

    public int getEndpoints_user_iotdevice() {
        return endpoints_user_iotdevice;
    }

    public void setEndpoints_user_iotdevice(int endpoints_user_iotdevice) {
        this.endpoints_user_iotdevice = endpoints_user_iotdevice;
    }

    public int getEndpoints_provider_iotdevice() {
        return endpoints_provider_iotdevice;
    }

    public void setEndpoints_provider_iotdevice(int endpoints_provider_iotdevice) {
        this.endpoints_provider_iotdevice = endpoints_provider_iotdevice;
    }

    public UserConfigBody(UserConfigBody userConfigBody) {
        this.url_endpoints = userConfigBody.url_endpoints;
        this.awtenantcode_endpoints = userConfigBody.awtenantcode_endpoints;
        this.serveruser_endpoints = userConfigBody.serveruser_endpoints;
        this.serverpassword_endpoints = userConfigBody.serverpassword_endpoints;
        this.endpoints_user_iotdevice = userConfigBody.endpoints_user_iotdevice;
        this.endpoints_provider_iotdevice = userConfigBody.endpoints_provider_iotdevice;
    }

    @Override
    public String toString() {
        return "UserConfigBody{" +
                "url_endpoints='" + url_endpoints + '\'' +
                ", awtenantcode_endpoints='" + awtenantcode_endpoints + '\'' +
                ", serveruser_endpoints='" + serveruser_endpoints + '\'' +
                ", serverpassword_endpoints='" + serverpassword_endpoints + '\'' +
                ", endpoints_user_iotdevice=" + endpoints_user_iotdevice +
                ", endpoints_provider_iotdevice=" + endpoints_provider_iotdevice +
                '}';
    }
}
