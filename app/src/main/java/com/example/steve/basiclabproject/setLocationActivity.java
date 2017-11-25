package com.example.steve.basiclabproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class setLocationActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private static final long MINIMUM_DISTANCE_FOR_UPDATES = 1;
    private static final long MINIMUM_TIME_FOR_UPDATES = 1000;
    protected LocationManager locationManager;
    double lati;
    double longi;
    SharedPreferences myShr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_location2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(LatLng point) {
        MarkerOptions marker= new MarkerOptions().position(new LatLng(point.latitude, point.longitude)).title("New Marker");
        mMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(point.latitude, point.longitude)).zoom(15).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        lati= point.latitude;
        longi = point.longitude;
        Geocoder geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
        try {
            List<Address> addresses = geoCoder.getFromLocation(lati,longi,1);
            String add="";
            if(addresses.size()>=0){
                //for(int i=0; i<addresses.get(0).getMaxAddressLineIndex();i++){
                    add =addresses.get(0).getAddressLine(0)+"\n"+lati +" "+longi;
                //}
            }
            Toast.makeText(getBaseContext(), add, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    public void sendLocationData(View view){
        Intent data=new Intent();
        data.putExtra("lact",String.valueOf(lati));
        data.putExtra("long",String.valueOf(longi));
        setResult(5,data);
        finish();//finishing activity
    }
}
