package com.project.android.nctu.facebook_googlemap_album;

import android.media.Image;

/**
 * Created by chichunchen on 4/21/15.
 */
public class Checkin {
    private String title;
    private double latitude;
    private double longitude;
    private String address;
    private String note;
    private Image image;

    public Checkin() {
        this.title = "";
        this.latitude = 0;
        this.longitude = 0;
        this.address = "";
        this.note = "";
    }

    public Checkin(String title, double latitude, double longitude) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
