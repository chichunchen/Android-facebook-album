package com.project.android.nctu.facebook_googlemap_album;

/**
 * Created by chichunchen on 4/17/15.
 */

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsInfo implements LocationListener {
    private LocationManager locationManager;

    public double lat = 0, lon = 0, speed = -1;

    public GpsInfo(LocationManager locationManager){
        this.locationManager = locationManager;

        try{
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, GpsInfo.this);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, GpsInfo.this);

            String bestProvider = LocationManager.GPS_PROVIDER;
            Criteria criteria = new Criteria();
            bestProvider = this.locationManager.getBestProvider(criteria, true);
            Location location = this.locationManager.getLastKnownLocation(bestProvider);
            lat = location.getLatitude();
            lon = location.getLongitude();
            speed = location.getSpeed();
        }
        catch(Exception e){
            lat = 0;
            lon = 0;
            speed = -1;
        }
    }


    public void getLocationInfo(int count, String dateTime){
        String content = count+"\t"+dateTime+"\t"+lat+"\t"+lon+"\t"+speed+"\n";
    }

    public void removeUpdates(){
        locationManager.removeUpdates(GpsInfo.this);
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();
        speed = location.getSpeed();
    }

    @Override
    public void onProviderDisabled(String arg0) {
    }

    @Override
    public void onProviderEnabled(String arg0) {
    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
    }
}