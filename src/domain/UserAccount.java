package domain;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALe = "F";

    private String username;
    private String gender;
    private String password;

    private List<String> roles;

    public UserAccount() {
    }

    public UserAccount(String username, String gender, String passWord, List<String> roles) {
        this.username = username;
        this.gender = gender;
        this.password = passWord;
        this.roles = new ArrayList<String>();
        if (roles != null) {
            for (String r: roles) {
              this.roles.add(r);
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
