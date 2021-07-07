package com.nextop.project.sentimap;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

public class NaverMapActivity extends Activity implements OnMapReadyCallback {

    private MapView mapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_naver_map);

        mapView = findViewById(R.id.act_naver_map);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        Marker marker = new Marker();
        marker.setPosition(new LatLng(37.5,126.9));
        marker.setMap(naverMap);
    }
}
