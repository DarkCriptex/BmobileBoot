package bmobile.graphs.LoginInterface;

public class User {
    private String user_client_iotdevice;

    private String name_leveluser;

    private String id_user;

    private String lastnames_user;

    private String name_user;

    private String serverpassword_endpoints;

    private String email_user;

    private String serveruser_endpoints;

    private String url_endpoints;

    private String awtenantcode_endpoints;

    private String name_client;

    public User(String user_client_iotdevice, String name_leveluser, String id_user,
                String lastnames_user, String name_user, String serverpassword_endpoints,
                String email_user, String serveruser_endpoints, String url_endpoints, String awtenantcode_endpoints, String name_client) {

        this.user_client_iotdevice = user_client_iotdevice;
        this.name_leveluser = name_leveluser;
        this.id_user = id_user;
        this.lastnames_user = lastnames_user;
        this.name_user = name_user;
        this.serverpassword_endpoints = serverpassword_endpoints;
        this.email_user = email_user;
        this.serveruser_endpoints = serveruser_endpoints;
        this.url_endpoints = url_endpoints;
        this.awtenantcode_endpoints = awtenantcode_endpoints;
        this.name_client = name_client;
    }



    public String getUser_client_iotdevice ()
    {
        return user_client_iotdevice;
    }

    public void setUser_client_iotdevice (String user_client_iotdevice)
    {
        this.user_client_iotdevice = user_client_iotdevice;
    }

    public String getName_leveluser ()
    {
        return name_leveluser;
    }

    public void setName_leveluser (String name_leveluser)
    {
        this.name_leveluser = name_leveluser;
    }

    public String getId_user ()
    {
        return id_user;
    }

    public void setId_user (String id_user)
    {
        this.id_user = id_user;
    }

    public String getLastnames_user ()
    {
        return lastnames_user;
    }

    public void setLastnames_user (String lastnames_user)
    {
        this.lastnames_user = lastnames_user;
    }

    public String getName_user ()
    {
        return name_user;
    }

    public void setName_user (String name_user)
    {
        this.name_user = name_user;
    }

    public String getServerpassword_endpoints ()
    {
        return serverpassword_endpoints;
    }

    public void setServerpassword_endpoints (String serverpassword_endpoints)
    {
        this.serverpassword_endpoints = serverpassword_endpoints;
    }

    public String getEmail_user ()
    {
        return email_user;
    }

    public void setEmail_user (String email_user)
    {
        this.email_user = email_user;
    }

    public String getServeruser_endpoints ()
    {
        return serveruser_endpoints;
    }

    public void setServeruser_endpoints (String serveruser_endpoints)
    {
        this.serveruser_endpoints = serveruser_endpoints;
    }

    public String getUrl_endpoints ()
    {
        return url_endpoints;
    }

    public void setUrl_endpoints (String url_endpoints)
    {
        this.url_endpoints = url_endpoints;
    }

    public String getAwtenantcode_endpoints ()
    {
        return awtenantcode_endpoints;
    }

    public void setAwtenantcode_endpoints (String awtenantcode_endpoints)
    {
        this.awtenantcode_endpoints = awtenantcode_endpoints;
    }

    public String getName_client ()
    {
        return name_client;
    }

    public void setName_client (String name_client)
    {
        this.name_client = name_client;
    }

}
