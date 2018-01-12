package crocusoft.android.myapp.pts.network.requests;

/**
 * Created by Asus on 1/11/2018.
 */

public class ForgotPasswordRequestClass {
    private String email;
    private String password;

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
