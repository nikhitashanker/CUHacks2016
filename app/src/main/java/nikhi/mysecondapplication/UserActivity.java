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


public class UserActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText edit2,edit3;
    int washes, meals;
    Firebase newRef;
    Firebase ref;
    User newUser;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Firebase.setAndroidContext(this);
        Intent i = getIntent();
        value = i.getStringExtra("name");
        MainActivity activity = new MainActivity();
        newUser = activity.getNewUser();
        System.out.println("newUSer" + newUser);




        Log.i(TAG, "Application is running");

        Button btn1 = (Button)(findViewById(R.id.buttonWash));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newDisplayWash(v);
            }
        });

        edit2 = (EditText) (findViewById(R.id.editText2));
        edit3 = (EditText) (findViewById(R.id.editText3));

        Button btn3 = (Button)(findViewById(R.id.buttonCook));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newDisplayCook(v);
            }
        });

        Button btn4 = (Button)(findViewById(R.id.buttonD));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newScreen(v);
            }
        });

    }

    public void newDisplayWash(View view){
        edit2.setVisibility(EditText.VISIBLE);

        edit2.setOnKeyListener(new View.OnKeyListener() {
        public boolean onKey(View view, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    washes = Integer.parseInt(edit2.getText().toString());

                    ref = new Firebase("https://project-6970500224315768028.firebaseio.com/users/"+value);
// Attach an listener to read the data at our posts reference
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");

                                ref.child("dishwasherloads").setValue(washes);
                                newUser = snapshot.getValue(User.class);
                                System.out.println("the users password is" + newUser.getChallengeBathroom());
                                System.out.println("washes" + washes);
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

    public void newDisplayCook(View view)
    {
        edit3.setVisibility(EditText.VISIBLE);
        edit3.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    meals = Integer.parseInt(edit3.getText().toString());

                    ref = new Firebase("https://project-6970500224315768028.firebaseio.com/users/" + value);
// Attach an listener to read the data at our posts reference
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");

                            ref.child("meals").setValue(meals);
                            newUser = snapshot.getValue(User.class);
                            newUser.setUserEmailandPass("gg", "gg");
                            System.out.println("washes" + washes);
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

