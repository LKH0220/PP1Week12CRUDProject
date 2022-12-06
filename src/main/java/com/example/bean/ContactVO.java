package com.example.bean;

import java.util.Date;

public class ContactVO {
    private int contactID;
    private String image;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String contactBirthday;
    private Date regdate;

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactBirthday() {
        return contactBirthday;
    }

    public void setContactBirthday(String contactBirthday) {
        this.contactBirthday = contactBirthday;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
