package bmobile.graphs.LoginInterface;

public class LoginBody {
    private String username;
    private String pass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public LoginBody(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }




}
