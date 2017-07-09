package com.idempiere.model;

/**
 * Created by ben on 08/07/17.
 */

public class X_Login_Detail {
    private String username;
    private String password;
    private int ad_User_ID;
    private int c_Bpartner_ID;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getC_Bpartner_ID() {
        return c_Bpartner_ID;
    }

    public void setC_Bpartner_ID(int c_Bpartner_ID) {
        this.c_Bpartner_ID = c_Bpartner_ID;
    }

    public int getAd_User_ID() {
        return ad_User_ID;
    }

    public void setAd_User_ID(int ad_User_ID) {
        this.ad_User_ID = ad_User_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
