/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0057;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class account implements Serializable {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public account() {
    }

    public account(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
