package com.project.android.nctu.facebook_googlemap_album;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MapActivity extends Activity implements OnMapReadyCallback {

    private String query;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);


        // test
//        Intent intent = getIntent();
//        query = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//
//        Context context = getApplicationContext();
//        Toast toast = Toast.makeText(context, query, Toast.LENGTH_LONG);
//        toast.show();


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

    public void takePhoto(View view) {
        dispatchTakePictureIntent();
    }

    private void dispatchTakePictureIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File tmpFile = new File(Environment.getExternalStorageDirectory(),"image.jpg");
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