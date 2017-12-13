package com.example.steve.basiclabproject;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.app.PendingIntent.getActivity;
import static android.widget.Toast.LENGTH_LONG;
import static java.lang.Double.valueOf;

public class buyActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentLocationMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    int PROXIMITY_RADIUS = 10000;
    List markers = new ArrayList();
    int[] id;
    JSONArray objectArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.apartement:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
               sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.residence:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.CountryHouse:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.cars:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.motorbikes:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.bicycles:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.PC:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.laptop:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.ComputerLaptopparts:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.mobilePhones:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.Guitars:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.Basses:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.Drums:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.Pneumatics:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.ClassicalOrgans:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.furnitures:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.homeDevices:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.Jewells:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.Design:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.Hobby:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.women:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.men:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.boys:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            case R.id.girls:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                sendJsonArraytofilter(item.getTitle().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission is granted
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (client == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    } else //permission denied
                    {
                        Toast.makeText(this, "Permission Denied!", Toast.LENGTH_LONG).show();
                    }
                    return;
                }
        }
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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);

        }//
        googleMap.setOnInfoWindowClickListener(this);
                readyMapCustom();

    }



    protected synchronized void buildGoogleApiClient() {
        client = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        client.connect();

    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation = location;

        if (currentLocationMarker != null) {
            currentLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        currentLocationMarker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(10));

        if (client != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(client, this);
        }

    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();

        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);

        }

    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);

            }
            return false;
        } else
            return true;
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override

    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(buyActivity.this, bargain.class);
        try {
            intent.putExtra("Title", marker.getTag().toString());
        } catch (Exception e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public void readyMapCustom(){
        JsonArrayRequest request = new JsonArrayRequest("https://team4success.000webhostapp.com/getDetailsbargain.php",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        id = new int[jsonArray.length()];
                        objectArray = jsonArray;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                id[i] = Integer.parseInt(jsonArray.getJSONObject(i).getString("productID"));
                                Marker marker = mMap.addMarker(new MarkerOptions().position((new LatLng(jsonArray.getJSONObject(i).getDouble("Lactitude"), jsonArray.getJSONObject(i).getDouble("Longtitude")))).title(jsonArray.getJSONObject(i).getString("ProductName")).snippet(jsonArray.getJSONObject(i).getString("price") + " Euros"));
                                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                                marker.setTag(jsonArray.getJSONObject(i));
                                markers.add(marker);
                            } catch (JSONException e) {
                                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(buyActivity.this);
                                dialogBuilder.setMessage("Error: " + e.getLocalizedMessage());
                                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                                //Toast.makeText(buyActivity.this, "Error: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                AlertDialog alertDialog = dialogBuilder.create();
                                alertDialog.show();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(buyActivity.this);
                        dialogBuilder.setMessage("Unable to fetch data: " + volleyError.getMessage());
                        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        //Toast.makeText(buyActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                        AlertDialog alertDialog = dialogBuilder.create();
                        alertDialog.show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void sendJsonArraytofilter(String subcategory){
        Intent intent= new Intent(buyActivity.this, filterBargain.class);
        intent.putExtra("subcategory",subcategory);
        startActivity(intent);
    }
}
