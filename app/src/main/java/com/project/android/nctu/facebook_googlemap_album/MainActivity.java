package com.project.android.nctu.facebook_googlemap_album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public static final String EXTRA_MESSAGE = "com.project.android.nctu.facebook_googlemap_album.INPUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        EditText searchMap = (EditText)findViewById(R.id.search_map);
        String message = searchMap.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void takePicture(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    public void fbLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                // TODO settings
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}