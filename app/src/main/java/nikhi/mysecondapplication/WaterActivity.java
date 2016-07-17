package nikhi.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WaterActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        Intent i = getIntent();
        value = i.getStringExtra("name");

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(getApplicationContext(),
                "Group Clicked " + listDataHeader.get(groupPosition),
                Toast.LENGTH_SHORT).show();
                if (groupPosition == 0) {
                    userScreen(v);
                }
                if (groupPosition == 1) {
                    gardeningScreen(v);
                }
                if (groupPosition == 2) {
                    bathroomActivity(v);
                }
                if (groupPosition == 3) {
                    laundryActivity(v);
                }
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();


            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    public void userScreen(View view){
        Intent startNewActivity = new Intent(this, UserActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }
    public void gardeningScreen(View view){
        Intent startNewActivity = new Intent(this, GardeningActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }
    public void bathroomActivity(View view){
        Intent startNewActivity = new Intent(this, BathroomActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }

    public void laundryActivity(View view){
        Intent startNewActivity = new Intent(this, LaundryActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Kitchen");
        listDataHeader.add("Gardening");
        listDataHeader.add("Bathroom");
        listDataHeader.add("Laundry");

        // Adding child data
        List<String> bathroom = new ArrayList<String>();
        bathroom.add("Showers");
        bathroom.add("Toilet");
        bathroom.add("Brushing Teeth");
        bathroom.add("Shaving");


        List<String> gardening = new ArrayList<String>();
        gardening.add("Plant choice");
        gardening.add("Method of watering");

        List<String> kitchen = new ArrayList<String>();
        kitchen.add("Diswashing");
        kitchen.add("Meals");

        List<String> laundry = new ArrayList<String>();
        laundry.add("Washer");


        listDataChild.put(listDataHeader.get(0), kitchen); // Header, Child data
        listDataChild.put(listDataHeader.get(1), gardening);
        listDataChild.put(listDataHeader.get(2), bathroom);
        listDataChild.put(listDataHeader.get(3), laundry);
    }
}
