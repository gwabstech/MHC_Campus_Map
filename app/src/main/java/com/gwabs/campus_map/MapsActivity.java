package com.gwabs.campus_map;

import static com.gwabs.campus_map.R.menu.nav_menu;

import android.Manifest;
import android.app.SearchManager;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentActivity;

import com.gwabs.campus_map.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;
    public ActivityMapsBinding binding;
    private EditText search_Bar;
    //listview object name
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private SupportMapFragment mapFragment;
    private View noResultsText;
    //array of building names (buildings)
    public String[] buildings = new String[]{
            //"COMMON SEARCHES",
            "Kadpoly computer science department",
            "Kadpoly Hospital",
            "Kaduna Polytechnic, Main Campus Central Mosque",
            "Kadpoly ICT Center",
            "ISA KAITA LIBRARY",
            "Electrical Engineering Department",
            "Kadpoly applied science",
            //"ACADEMIC BUILDINGS",
            "Kadpoly computer science department",
            "Kadpoly Hospital",
            "Kaduna Polytechnic, Main Campus Central Mosque",
            "Kadpoly ICT Center",
            "ISA KAITA LIBRARY",
            "Electrical Engineering Department",
            "Kadpoly applied science",
            "Kadpoly statistic department",
            "Kadpoly department Leisure and tourism",
            "Kadpoly department of nutrition and dietetics",
            "Conventional Centre",
            "Department Of Printing Technology.",
            "Kaduna Polytechnic college of Engineering",
            "Mohammed Dikko Lecture Theatre",
            "Civil Engineering Department",
            "Kadpoly Hospital",
            "Kaduna Polytechnic, Main Campus Central Mosque",
            "Kadpoly agri-tech class",
            "College Of Science and Technology",
            "SPIDER RADIO (Campus FM)",
            "Kadpoly small Gate",
            "Main Campus Female Hostel",
            "Main Campus boys hostel"
    };

    public MapsActivity() {
    }

    public void zoomToBuildingLocation(String buildingName) {
        //COMMON SEARCHES
        if (buildingName.equals("Kadpoly computer science department")) {

            // Add a marker in Harriet Newhall Center of Admissions and zoom in the camera
            LatLng admissions = new LatLng(10.525171966137856, 7.41466939668644);
            mMap.addMarker(new MarkerOptions().position(admissions).title("Computer Science"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(admissions, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly Hospital")) {

            // Add a marker in Community center and zoom in the camera
            LatLng Communitycenter = new LatLng(10.524253683236916, 7.415983902531572);
            mMap.addMarker(new MarkerOptions().position(Communitycenter).title("Medical Center"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Communitycenter, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kaduna Polytechnic, Main Campus Central Mosque")) {

            // Add a marker in Community center and zoom in the camera
            LatLng MaryWoolleyHall = new LatLng(10.521347107176133, 7.413337031061597);
            mMap.addMarker(new MarkerOptions().position(MaryWoolleyHall).title("Central Mosque"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MaryWoolleyHall, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly ICT Center")) {


            // Add a marker in Community center and zoom in the camera
            LatLng EquestrianCenter = new LatLng(10.52587120731516, 7.413850355635819);
            mMap.addMarker(new MarkerOptions().position(EquestrianCenter).title("ICT Center"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(EquestrianCenter, 20.0f), 5000, null);
        }

        if (buildingName.equals("ISA KAITA LIBRARY")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng WillistonLibrary = new LatLng(10.523309063810895, 7.41608146359013);
            mMap.addMarker(new MarkerOptions().position(WillistonLibrary).title("ISA KAITA LIBRARY"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(WillistonLibrary, 20.0f), 5000, null);
        }

        if (buildingName.equals("Electrical Engineering Department")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng ConferenceCenter = new LatLng(10.525624597532875, 7.41118490558347);
            mMap.addMarker(new MarkerOptions().position(ConferenceCenter).title("Electrical Engineering Department"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ConferenceCenter, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly applied science")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng BlanchardHall = new LatLng(10.522116883320978, 7.4151995905787045);
            mMap.addMarker(new MarkerOptions().position(BlanchardHall).title("Blanchard Hall"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(BlanchardHall, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly statistic department")) {

           // ,
            // Add a marker in Community center and zoom in the camera
            LatLng carr = new LatLng(10.522674951463564, 7.414550738448187);
            mMap.addMarker(new MarkerOptions().position(carr).title("Statistic Department"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(carr, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly department Leisure and tourism")) {

            // Add a marker in Community center and zoom in the camera
            LatLng ciruti = new LatLng(10.523547215297802, 7.413993494886854);
            mMap.addMarker(new MarkerOptions().position(ciruti).title("Department Leisure and Tourism"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ciruti, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly department of nutrition and dietetics")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng clapp = new LatLng(10.523773602183962, 7.413219039015981);
            mMap.addMarker(new MarkerOptions().position(clapp).title("department of nutrition and dietetics"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(clapp, 20.0f), 5000, null);
        }

        if (buildingName.equals("Conventional Centre")) {

            // Add a marker in Community center and zoom in the camera
            LatLng Cleveland = new LatLng(10.525533976349159, 7.412233984658609);
            mMap.addMarker(new MarkerOptions().position(Cleveland).title("Conventional Centre"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Cleveland, 20.0f), 5000, null);
        }

        if (buildingName.equals("Department Of Printing Technology.")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng dwight = new LatLng(10.461384861606627, 7.382367534925575);
            mMap.addMarker(new MarkerOptions().position(dwight).title("Printing Technology"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dwight, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kaduna Polytechnic college of Engineering")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng Emeriti = new LatLng(10.530490396213464, 7.4121384545721485);
            mMap.addMarker(new MarkerOptions().position(Emeriti).title("College of Engineering"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Emeriti, 20.0f), 5000, null);
        }

        if (buildingName.equals("Mohammed Dikko Lecture Theatre")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng Gorse = new LatLng(10.528071498798452, 7.41198521018079156);
            mMap.addMarker(new MarkerOptions().position(Gorse).title("Mohammed Dikko Lecture Theatre"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Gorse, 20.0f), 5000, null);
        }

        if (buildingName.equals("Civil Engineering Department")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng Kendade = new LatLng(10.530013281494439, 7.415297792471287);
            mMap.addMarker(new MarkerOptions().position(Kendade).title("Civil Engineering"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Kendade, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly agri-tech class")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng Porter = new LatLng(10.523766687622206, 7.4160542806895995);
            mMap.addMarker(new MarkerOptions().position(Porter).title("Agri-tech"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Porter, 20.0f), 5000, null);
        }

        if (buildingName.equals("College Of Science and Technology")) {

          //  ,
            // Add a marker in Community center and zoom in the camera
            LatLng Pratt = new LatLng(10.521497642087592,  7.414064394701438);
            mMap.addMarker(new MarkerOptions().position(Pratt).title("Pratt Music Hall"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Pratt, 20.0f), 5000, null);
        }

        if (buildingName.equals("SPIDER RADIO (Campus FM)")) {
            //,
            // Add a marker in Community center and zoom in the camera
            LatLng Reese = new LatLng(10.527080951309019, 7.412513781436824);
            mMap.addMarker(new MarkerOptions().position(Reese).title("SPIDER RADIO"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Reese, 20.0f), 5000, null);
        }

        if (buildingName.equals("Kadpoly small Gate")) {

            //,
            // Add a marker in Community center and zoom in the camera
            LatLng Rooke = new LatLng(10.52154791942063, 7.415192994496393);
            mMap.addMarker(new MarkerOptions().position(Rooke).title("Kadpoly small Gate"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Rooke, 20.0f), 5000, null);
        }

        if (buildingName.equals("Main Campus Female Hostel")) {

           // ,
            // Add a marker in Community center and zoom in the camera
            LatLng morgan = new LatLng(10.529386534583555, 7.411622853129202);
            mMap.addMarker(new MarkerOptions().position(morgan).title("Campus Female Hostel"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(morgan, 20.0f), 5000, null);
        }

        if (buildingName.equals("Main Campus boys hostel")) {

            // Add a marker in Community center and zoom in the camera
            LatLng park = new LatLng(10.529386534583555, 7.411622853129202);
            mMap.addMarker(new MarkerOptions().position(park).title("Campus boys hostel"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(park, 20.0f), 5000, null);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noResultsText = findViewById(R.id.no_results_text);
        View mapView = findViewById(R.id.map);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //map doesn't show up until a building is searched or pressed
        mapFragment.getView().setVisibility(View.INVISIBLE);

        SearchView searchView = findViewById(R.id.search_bar);
        // Create a SimpleCursorAdapter for the suggestions
        String[] from = {SearchManager.SUGGEST_COLUMN_TEXT_1};
        int[] to = {android.R.id.text1};
        SimpleCursorAdapter adapter1 = new SimpleCursorAdapter(this,
                android.R.layout.simple_dropdown_item_1line, null, from, to, 0);
        searchView.setSuggestionsAdapter(adapter1);
        mapFragment.getView().setVisibility(View.INVISIBLE);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hide the map when the search bar is clicked
                mapFragment.getView().setVisibility(View.INVISIBLE);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search or filtering logic here
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<String> suggestions = new ArrayList<>();
                for (String building : buildings) {
                    if (building.toLowerCase().contains(newText.toLowerCase())) {
                        suggestions.add(building);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MapsActivity.this, android.R.layout.simple_list_item_1, suggestions);
                listView.setVisibility(View.VISIBLE);
                listView.setAdapter(adapter);
                return true;
            }
        });
// Handle suggestion click events
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {

                return false;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                // Retrieve the clicked suggestion from the adapter
                String selectedBuilding = adapter.getItem(position);

                // Perform action when a suggestion is clicked (e.g., zoom to building location)
                zoomToBuildingLocation(selectedBuilding);

                // Clear the search query and close the search view
                searchView.setQuery("", false);
                searchView.setIconified(true);

                return true;
            }
        });
        //set layout manager on xml
        listView=(ListView)findViewById(R.id.myListview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    listView.setVisibility(View.VISIBLE);
                    mapFragment.getView().setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.GONE);
                    mapFragment.getView().setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, buildings);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(((parent, view, position, id) -> {
            mapFragment.getView().setVisibility(View.VISIBLE);
            listView.setVisibility(View.INVISIBLE);
            String buildingName= adapter.getItem(position);
            zoomToBuildingLocation(buildingName);
        }));

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),buildings[position]+ "was selected.", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                Toast.makeText(getApplicationContext(),"None Selected.", Toast.LENGTH_SHORT).show();

            }

        });



        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(nav_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> filterList = new ArrayList<>();
                for(String tempbuildings : buildings){
                    //typed on search bar matches object in list //startsWith or contains
                    if(tempbuildings.toLowerCase().contains(newText.toLowerCase())){
                        filterList.add(tempbuildings);
                    }
                }
                ArrayAdapter<String> adapterwithFilteredList = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, filterList);
                listView.setAdapter(adapterwithFilteredList);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
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
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.setTrafficEnabled(true);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

}