package org.shellhacks.dash

import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        mMap.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(this)
        { location ->
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)

        val FIU271B = LatLng(25.7558281, -80.3729165)
        val FIU287B = LatLng(25.7558347, -80.3727810)
        val FIU279B = LatLng(25.7555645, -80.3725745)
        val FIU278A  = LatLng(25.7556043, -80.3727354)
        val FIU277 = LatLng(25.7555666, -80.3727428)
        val FIU276 = LatLng(25.7556538, -80.3728605)
        val FIU280 = LatLng(25.7556430, -80.3726080)
        val FIU285 = LatLng(25.7557867, -80.3726084)
        val FIU271A = LatLng(25.7558719, -80.3728907)
        val FIU275B = LatLng(25.7556082, -80.3728920)
        mMap.addMarker(MarkerOptions().position(FIU271B).title("271B 08:4f:a9:1e:05:8f").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU287B).title("287B 08:4f:a9:3c:4e:ef").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU279B).title("279B 08:4f:a9:73:d5:8f").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU278A).title("278A 08:4f:a9:41:30:cf").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU277).title("277 08:4f:a9:32:1d:2f").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU276).title("276 08:4f:a9:32:1d:0f").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU280).title("280 fc:5b:39:88:14:4f").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU285).title("285 7c:0e:ce:0efb:8f").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU271A).title("271A a0:ec:f9:9f:83:bf").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        mMap.addMarker(MarkerOptions().position(FIU275B).title("275B fc:5b:39:a1:bb:1f").alpha(0.5f)
            .icon(BitmapDescriptorFactory.defaultMarker(225.0f)))
        //20 Minimum Zoom to Show Buildings
        mMap.setMinZoomPreference(19.0f)
        mMap.setMaxZoomPreference(25.0f)
        mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        val circle = mMap.addCircle(CircleOptions().center(
            LatLng(25.75562, -80.3726))
            .radius(10.0)
            .fillColor(Color.RED)
            .strokeColor(Color.BLACK)
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLng(FIU271B))
        setUpMap()
    }

    override fun onMarkerClick(marker: Marker):Boolean {
        return true
    }

}
