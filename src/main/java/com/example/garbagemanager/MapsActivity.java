package com.example.garbagemanager;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.garbagemanager.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
  EditText e1;
  private GoogleMap mMap;
  private ActivityMapsBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMapsBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
      .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);

    Button b1=findViewById(R.id.but);

    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        tt();
      }
    });
  }


  @Override
  public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    LatLng sydney = new LatLng(-34, 151);
    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
  }

  public void tt()
  {
    String st=binding.e1.getText().toString();
    Geocoder geocoder=new Geocoder(getApplicationContext());

    List<Address> list=new ArrayList<>();

    try {
      list=geocoder.getFromLocationName(st,1);

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    if(list.size()>0)
    {
      Address address=list.get(0);
      String loction=address.getAdminArea();
      double latitude=address.getLatitude();
      double longtitude=address.getLatitude();
      gotoLating(latitude,longtitude,17f);
    }
  }

  private void gotoLating(double latitude,double longtitude,float v )
  {
    LatLng latLng=new LatLng(latitude,longtitude);
    CameraUpdate cameraUpdate=CameraUpdateFactory.newLatLngZoom(latLng,17f);
    mMap.animateCamera(cameraUpdate);
  }
}
