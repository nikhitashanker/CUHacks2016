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

public class LaundryActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText editText;
    int load;
    String value;
    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);
        Firebase.setAndroidContext(this);
        Log.i(TAG, "Application is running");
        Intent i = getIntent();
        value = i.getStringExtra("name");

        Button btn1 = (Button)(findViewById(R.id.laundry));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newLoad(v);
            }
        });

        editText = (EditText) (findViewById(R.id.editTextLaundry));

        Button btn3 = (Button)(findViewById(R.id.dashboard));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newScreen(v);
            }
        });

    }



        public void newLoad (View view){
        editText.setVisibility(EditText.VISIBLE);
            editText.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View view, int keyCode, KeyEvent event) {
                    // If the event is a key-down event on the "enter" button
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on key press
                        load = Integer.parseInt(editText.getText().toString());
                        System.out.println("feet"+load);

                        ref = new Firebase("https://project-6970500224315768028.firebaseio.com/users/" + value);
// Attach an listener to read the data at our posts reference
                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");

                                ref.child("laundryloads").setValue(load);

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

