package nikhi.mysecondapplication;

/**
 * Created by nikhi on 6/10/16.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class BathroomActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText editShower,editFaucet,editBath,editToilet ;
    int showers,baths,toiletFlushes,faucets;
    Firebase ref;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);
        Log.i(TAG, "Application is running");
        Intent i = getIntent();
        value = i.getStringExtra("name");

        Button btn1 = (Button)(findViewById(R.id.showering));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newShower(v);
            }
        });

        editShower = (EditText) (findViewById(R.id.editTextShower));
        editFaucet = (EditText) (findViewById(R.id.editTextFaucet));
        editBath = (EditText) (findViewById(R.id.editTextBath));
        editToilet = (EditText) (findViewById(R.id.editTextToilet));


        Button btn3 = (Button)(findViewById(R.id.faucet));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newFaucet(v);
            }
        });

        Button btn4 = (Button)(findViewById(R.id.toilet));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newToilet(v);
            }
        });

        Button btn5 = (Button)(findViewById(R.id.bath));
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newBath(v);
            }
        });

        Button btn6 = (Button)(findViewById(R.id.dashboard));
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newScreen(v);
            }
        });
    }

    public void newShower(View view){
        editShower.setVisibility(EditText.VISIBLE);
        editShower.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    showers = Integer.parseInt(editShower.getText().toString());

                    ref = new Firebase("https://project-6970500224315768028.firebaseio.com/users/"+value);
// Attach an listener to read the data at our posts reference
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");

                            ref.child("showerMinutes").setValue(showers);

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            System.out.println("The read failed: " + firebaseError.getMessage());
                        }
                    });

                    return true;
                }
                return false;
            }
        });
    }



    public void newToilet(View view){
        editToilet.setVisibility(EditText.VISIBLE);
        editToilet.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    toiletFlushes = Integer.parseInt(editToilet.getText().toString());

                    ref = new Firebase("https://project-6970500224315768028.firebaseio.com/users/"+value);
// Attach an listener to read the data at our posts reference
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                            System.out.println("Flushes " + toiletFlushes);
                            ref.child("flushes").setValue(toiletFlushes);

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            System.out.println("The read failed: " + firebaseError.getMessage());
                        }
                    });

                    return true;
                }
                return false;
            }
        });
    }


    public void newBath(View view){
        editBath.setVisibility(EditText.VISIBLE);
    }

    public void newFaucet(View view){
        editFaucet.setVisibility(EditText.VISIBLE);
    }



    public void newScreen (View view)
    {
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }
}

