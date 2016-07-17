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

public class GardeningActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText edit2;
    int feet;
    Firebase ref;
    User newUser;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardening);
        Intent i = getIntent();
        value = i.getStringExtra("name");
        Log.i(TAG, "Application is running");
        edit2 = (EditText) (findViewById(R.id.sqFeet));
        Button btn1 = (Button)(findViewById(R.id.wateringLawn));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newFeetWash(v);
            }
        });



        Button btn3 = (Button)(findViewById(R.id.dashboard));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newScreen(v);
            }
        });





    }

    public void newFeetWash (View view){
        edit2.setVisibility(EditText.VISIBLE);
        edit2.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    feet = Integer.parseInt(edit2.getText().toString());
                    System.out.println("feet"+feet);

                    ref = new Firebase("https://project-6970500224315768028.firebaseio.com/users/" + value);
// Attach an listener to read the data at our posts reference
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");

                            ref.child("squarefeetofusersgarden").setValue(feet);

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



    public void newScreen (View view)
    {
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }
}
