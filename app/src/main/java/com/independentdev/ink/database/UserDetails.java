package com.independentdev.ink.database;

import io.realm.RealmObject;

/**
 * Created by sanjayjith.madhavan on 2/16/2017.
 */

public class UserDetails extends RealmObject {

    private String fullName;
    private String mailId;
    private String mobileNo;
    private String password;
    private String userPic;
    private String coverPic;
    private String loginWith;
    private String loginApiKey;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getLoginWith() {
        return loginWith;
    }

    public void setLoginWith(String loginWith) {
        this.loginWith = loginWith;
    }

    public String getLoginApiKey() {
        return loginApiKey;
    }

    public void setLoginApiKey(String loginApiKey) {
        this.loginApiKey = loginApiKey;
    }
}
