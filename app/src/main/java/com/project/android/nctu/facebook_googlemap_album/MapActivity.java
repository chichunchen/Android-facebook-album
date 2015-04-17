package com.project.android.nctu.facebook_googlemap_album;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MapActivity extends Activity implements OnMapReadyCallback {

    private String query;
    private GpsInfo gpsInfo;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        // init gps
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        gpsInfo = new GpsInfo(locationManager);

//        Context context = getApplicationContext();
//        Toast toast = Toast.makeText(context, query + "lat: " + gpsInfo.lat + "/ lon: " + gpsInfo.lon, Toast.LENGTH_SHORT);
//        toast.show();

        // map
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng current_place = new LatLng(25.0336, 121.5650);
        // LatLng current_place = new LatLng(gpsInfo.lon, gpsInfo.lat);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(current_place, 13));

        map.addMarker(new MarkerOptions()
                .title(query)
                .snippet("Welcome to fb album.")
                .position(current_place));
    }

    // TODO gpsInfo.removeUpdates();

    public void takePhoto(View view) {
        dispatchTakePictureIntent();
    }

    private void dispatchTakePictureIntent() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(c.getTime());

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File tmpFile = new File(Environment.getExternalStorageDirectory(),"Pictures/fbcheckin-" + strDate + ".jpg");
        Uri outputFileUri = Uri.fromFile(tmpFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            // Bitmap bitmap = BitmapFactory.decodeFile(Environment
            //         .getExternalStorageDirectory() + "/image.jpg");
            // .setImageBitmap(bitmap);
        }
    }

    public void shareInfo(View view) {
        // TODO share information
    }
}