package com.project.android.nctu.facebook_googlemap_album;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MapActivity extends Activity implements OnMapReadyCallback {

    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);


        // test
        Intent intent = getIntent();
        query = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, query, Toast.LENGTH_LONG);
        toast.show();


        // map
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng current_place = new LatLng(25.0336, 121.5650);
        // LatLng place = (LatLng)PlacePicker.getPlace(query, this);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(current_place, 13));

        map.addMarker(new MarkerOptions()
                .title(query)
                .snippet("Welcome to fb album.")
                .position(current_place));
    }
}