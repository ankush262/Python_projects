package com.geekymusketeers.taketoocare;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.geekymusketeers.taketoocare.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 123;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    // Use the obtained location here
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Toast.makeText(MapsActivity.this, "Latitude: " + latitude + " Longitude: " + longitude, Toast.LENGTH_SHORT).show();
                    LatLng latLng = new LatLng(latitude, longitude);
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(latLng)
                            .zoom(15) // Zoom level (0-21)
                            .build();
                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            }
        };

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            requestLocationUpdates();
        }
    }

    private void requestLocationUpdates() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000); // Update location every 5 seconds

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestLocationUpdates();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fusedLocationClient.removeLocationUpdates(locationCallback);

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
        LatLng hospitalLatLng = new LatLng(18.60309953711653, 73.90919519122932);
        // Add a marker in Sydney and move the camera
        CameraPosition googlePlex = CameraPosition.builder()
                .target(hospitalLatLng)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng).title("Dhavan Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 2000, null);



        LatLng hospitalLatLng2 = new LatLng(18.602530113236924, 73.91116929695278);
        CameraPosition googlePlex2 = CameraPosition.builder()
                .target(hospitalLatLng2)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng2).title("Orchid Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex2), 2000, null);


        LatLng hospitalLatLng3 = new LatLng(18.59842931099793, 73.90376803303775);
        CameraPosition googlePlex3 = CameraPosition.builder()
                .target(hospitalLatLng3)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng3).title("ct Nursing Home"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex3), 2000, null);


        LatLng hospitalLatLng4 = new LatLng(18.597112468360436, 73.90925936547157);
        CameraPosition googlePlex4 = CameraPosition.builder()
                .target(hospitalLatLng4)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng4).title("Mother teresa charitable Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex4), 2000, null);


        LatLng hospitalLatLng5 = new LatLng(18.620460381888588, 73.91122591690818);
        CameraPosition googlePlex5 = CameraPosition.builder()
                .target(hospitalLatLng5)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng5).title("D.Y Dental School"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex5), 2000, null);


        LatLng hospitalLatLng6 = new LatLng(118.60085607696005, 73.92370766652014);
        CameraPosition googlePlex6 = CameraPosition.builder()
                .target(hospitalLatLng6)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng6).title("Aarogya Homoeopathic Clinic"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex6), 2000, null);


        LatLng hospitalLatLng7 = new LatLng(18.594743063242127, 73.92832002648898);
        CameraPosition googlePlex7 = CameraPosition.builder()
                .target(hospitalLatLng7)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng7).title("Sparsh Hospital Physiotherapy Centre"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex7), 2000, null);


        LatLng hospitalLatLng8 = new LatLng(18.622302539723876, 73.86890787033909);
        CameraPosition googlePlex8 = CameraPosition.builder()
                .target(hospitalLatLng8)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng8).title("Mato Shree Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex8), 2000, null);


        LatLng hospitalLatLng9 = new LatLng(18.654456234429357, 73.88229820342731);
        CameraPosition googlePlex9 = CameraPosition.builder()
                .target(hospitalLatLng9)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng9).title("Reise Hospitality"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex9), 2000, null);


        LatLng hospitalLatLng10 = new LatLng(18.67515067561502, 73.88202093595908);
        CameraPosition googlePlex10 = CameraPosition.builder()
                .target(hospitalLatLng10)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng10).title("Chauhan Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex10), 2000, null);


        LatLng hospitalLatLng11 = new LatLng(18.617018186060314, 73.8741031359591);
        CameraPosition googlePlex11 = CameraPosition.builder()
                .target(hospitalLatLng11)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng11).title("Om Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex11), 2000, null);


        LatLng hospitalLatLng12 = new LatLng(18.64879181823353, 73.8771529109843);
        CameraPosition googlePlex12 = CameraPosition.builder()
                .target(hospitalLatLng12)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng12).title("Rahane Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex12), 2000, null);


        LatLng hospitalLatLng13 = new LatLng(18.532080093356644, 73.84447561356995);
        CameraPosition googlePlex13 = CameraPosition.builder()
                .target(hospitalLatLng13)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng13).title("Deccan Hardikar Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex13), 2000, null);


        LatLng hospitalLatLng14 = new LatLng(18.525048180365584, 73.86380834220378);
        CameraPosition googlePlex14 = CameraPosition.builder()
                .target(hospitalLatLng14)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng14).title("Kamla Nehru Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex14), 2000, null);


        LatLng hospitalLatLng15 = new LatLng(18.504881662974352, 73.90083625768179);
        CameraPosition googlePlex15 = CameraPosition.builder()
                .target(hospitalLatLng15)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng15).title("Inamdar Multispeciality Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex15), 2000, null);


        LatLng hospitalLatLng16 = new LatLng(18.597994814697905, 73.75636592960606);
        CameraPosition googlePlex16 = CameraPosition.builder()
                .target(hospitalLatLng16)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng16).title("Lifepoint Multispecialty Hospital, Wakad"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex16), 2000, null);


        LatLng hospitalLatLng17 = new LatLng(18.51402662421015, 73.84011982376907);
        CameraPosition googlePlex17 = CameraPosition.builder()
                .target(hospitalLatLng17)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng17).title("Sahyadri Super Speciality Hospital, Deccan Gymkhana, Pune"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex17), 2000, null);


        LatLng hospitalLatLng18 = new LatLng(18.511301355997563, 73.84261167955651);
        CameraPosition googlePlex18 = CameraPosition.builder()
                .target(hospitalLatLng18)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng18).title("Poona Hospital And Research Centre"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex18), 2000, null);


        LatLng hospitalLatLng19 = new LatLng(18.599368154956274, 73.79489648568091);
        CameraPosition googlePlex19 = CameraPosition.builder()
                .target(hospitalLatLng19)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng19).title("Lotus Multispeciality Hospital"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex19), 2000, null);


        LatLng hospitalLatLng20 = new LatLng(18.560029283660253, 73.80364470471905);
        CameraPosition googlePlex20 = CameraPosition.builder()
                .target(hospitalLatLng20)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng20).title("Shashwat Hospital Aundh"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex20), 2000,null);

        LatLng hospitalLatLng1 = new LatLng(18.621482770001748, 73.91082597421827);
        CameraPosition googlePlex1 = CameraPosition.builder()
                .target(hospitalLatLng1)
                .zoom(16f)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.addMarker(new MarkerOptions().position(hospitalLatLng1).title("Ajeenkya healthcare"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex1), 2000, null);

    }


}