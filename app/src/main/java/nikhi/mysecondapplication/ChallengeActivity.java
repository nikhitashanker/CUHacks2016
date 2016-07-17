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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChallengeActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String value;
    Firebase ref;
    User user;
    String challengeBathroom;
    String challengeGarden;
    String challengeLaundry;
    String challengeKitchen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        Intent i = getIntent();
        value = i.getStringExtra("name");
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        Firebase.setAndroidContext(this);


        ref = new Firebase("https://project-6970500224315768028.firebaseio.com/users/" + value);
// Attach an listener to read the data at our posts reference








        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        //user = new User();
        // preparing list data
        //user = new User();


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
                if (groupPosition == 4)
                    newScreen(v);
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
                if (groupPosition == 0) {
                    newScreenShowering(v);
                }
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

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //ref.child("changed").setValue(4);
                user = snapshot.getValue(User.class);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        logic();

    }

    public void newScreen (View view)
    {
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }

    public void newScreenShowering(View view){
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startActivity(startNewActivity);
    }



    public void logic() {
        // please finish :) thanks call me at 408 - 242 - 6693
        //create strings for the challenges based on vars
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //BATHROOM CHALLENGE
                System.out.println("user" + user);
                user = snapshot.getValue(User.class);

                int flushes = user.getFlushes();
                int showerMinutes = user.getShowerMinutes();
                int meals = user.getMeals();
                int dishwasherloads = user.getDishwasherloads();
                int laundryloads = user.getLaundryloads();

                if (flushes <= 6 && flushes >=0)
                {
                    challengeBathroom= "You are doing well with toilet use. Upgrade toilet for possible rebates \n";
                }
                else
                {
                    challengeBathroom= "Decrease your toilet use and upgrade toilet for possible rebates \n";
                }
                if (showerMinutes >= 10)
                {
                    challengeBathroom+= "Take 5-10 minute showers and upgrade your shower head";
                }
                else
                {
                    challengeBathroom+= "You are doing well with showers. Upgrade shower head for possible rebates.";
                }

                //KITCHEN CHALLENGE


                if (meals * 1.76 <= 7)
                {
                    challengeKitchen = "You are doing well with water use for cooking. Check the type of kitchen faucet for possible rebates \n";
                }
                else
                {
                    challengeKitchen = "Decrease kitchen faucet use and consider upgrading your faucet \n";
                }

                if (dishwasherloads >= 2)
                {
                    challengeKitchen+= "Consider decreasing use of dishwasher and highly consider upgrading your dishwasher for possible rebates";
                }
                else
                {
                    challengeKitchen+= "Check your dishwasher model and consider upgrading your dishwasher for possible rebates.";
                }

                // LAUNDRY CHALLENGE

                if (laundryloads >=2)
                {
                    challengeLaundry= "Consider upgrading your laundry machines and reduce your loads to around 2/week.";
                }
                else
                    challengeLaundry= "You are doing well with your laundry. Consider upgrading your laundry machines for more saving.";

                //GARDEN CHALLENGE
                //because the tips are the same
                challengeGarden = "Consider making part of your lawn as artificial landscape to save money.";

                // Adding child data
                listDataHeader.add("Kitchen");
                listDataHeader.add("Bathroom");
                listDataHeader.add("Laundry");
                listDataHeader.add("Garden");
                listDataHeader.add("Dashboard");

                // Adding child data

                List<String> dishwashing = new ArrayList<String>();
                dishwashing.add(challengeKitchen);
                // dishwashing.add("-Wash dishes by hand in a small tub, using the same water");

                List<String> bathroom = new ArrayList<String>();
       /* bathroom.add("-Get water-saving toilets");
        bathroom.add("-Challenge yourself to take shorter showers--try toget your time as low as possible!");
        bathroom.add("-Turn off the faucet when brushing your teeth");
        bathroom.add("-Don't take baths. They use up much more water than a short, sensible shower.");*/
                bathroom.add(challengeBathroom);

                List<String> laundry = new ArrayList<String>();
                //laundry.add("-Get a water-saving laundry machine");
                //laundry.add("-Make sure to use the right settings");
                //laundry.add("-If you don't have enough clothing to make a complete load, wait, or wash the clothes by hand");
                laundry.add(challengeLaundry);

                List <String> garden = new ArrayList<String>();
                garden.add(challengeGarden);

                List <String> dash = new ArrayList<String>();


                listDataChild.put(listDataHeader.get(0), dishwashing); // Header, Child data
                listDataChild.put(listDataHeader.get(1), bathroom);
                listDataChild.put(listDataHeader.get(2), laundry);
                listDataChild.put(listDataHeader.get(3),garden);
                listDataChild.put(listDataHeader.get(4),dash);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }


        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {



    }
}