package com.example.homecareconnect.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.homecareconnect.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

// Implement OnMapReadyCallback.
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private final int FINE_PERMISSION_CODE = 1;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout file as the content view.
        setContentView(R.layout.activity_main);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
        // Get a handle to the fragment and register the callback.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

//        googleMap.getUiSettings().setMapToolbarEnabled(false);
//        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        moveMap(googleMap,currentLocation.getLatitude(), currentLocation.getLongitude());
    }

    private void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
            return;
        }
        else {
            Log.v("OnlyThisOne", "Requests Granted " );
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();

        task.addOnSuccessListener(location -> {
            Log.v("Location", "Location:  "+ location );
            if(location != null){
                currentLocation = location;
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                mapFragment.getMapAsync(MainActivity.this);
            }
            else {
                Log.v("Map", "Location Null " );
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == FINE_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {
                getLastLocation();
            }else{
                Toast.makeText(this,"Location permission is denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void moveMap(GoogleMap gMap, double latitude, double longitude) {
        Log.v("Map", "mapMoved: " + gMap);
        LatLng latlng = new LatLng(latitude, longitude);
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(latlng, 6);
        gMap.addMarker(new MarkerOptions().position(latlng));
        gMap.moveCamera(cu);
    }

}


//public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        // Set the layout file as the content view.
//        setContentView(R.layout.activity_main);
//
//        // Get a handle to the fragment and register the callback.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//    // Get a handle to the GoogleMap object and display marker.
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(0, 0))
//                .title("Marker"));
//    }
//}