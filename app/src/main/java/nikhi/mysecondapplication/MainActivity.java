package nikhi.mysecondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static String TAG = "Main Activity";


    EditText email;
    String email_str = "";
    String nodot = "";
    String pass_str = "";

    EditText password;
    EditText email2;
    EditText password2;
    Button create;
    Firebase ref;
    User newUser;
    boolean accountCreated = false;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://project-6970500224315768028.firebaseio.com/");
        //This is a trial
        Firebase usersRef = ref.child("users");

        //create new user class with hours etc.


        setContentView(R.layout.activity_main);
        Log.d("myRef", ref.toString());
        Log.i(TAG, "Application is running");
        email = (EditText) findViewById(R.id.editText_email);
        password = (EditText) findViewById(R.id.editText_password);
        create = (Button) findViewById(R.id.button_caccount);
        email2 = (EditText) findViewById(R.id.email2);
        password2 = (EditText) findViewById(R.id.password2);
        signin = (Button) findViewById(R.id.signin);


        //if (accountCreated == false) {
            accountCreated = true;
            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("Hi");

                    email_str = email.getText().toString();
                    pass_str = password.getText().toString();

                    System.out.println(email_str+pass_str);

                    Firebase usersRef = ref.child("users");
                    Map<String, String> newMap = new HashMap<String, String>();
                    newMap.put("username", email_str);
                    newMap.put("password", pass_str);
                    Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
                    //users.put("newUser", newMap);
                    //usersRef.setValue(users);

                    nodot = email_str.substring(0, email_str.length() - 5);
                    Firebase newRef = ref.child("users").child(nodot);
                    newUser = new User();
                    newUser.setUserEmailandPass(email_str, pass_str);
                    newRef.setValue(newUser);
                    System.out.print("initial" + newUser.getEmail());
                        Log.i(TAG, "Button was clicked");
                        newScreen(v);


                }
            });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hi");

                String email_str2 = email2.getText().toString();
                String pass_str2 = password2.getText().toString();

                System.out.println(email_str+pass_str);



                nodot = email_str2.substring(0, email_str2.length() - 5);
                    Log.i(TAG, "Button was clicked");
                    newScreen(v);

            }
        });




        //}
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        //GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                //.requestEmail()
                //.build();
        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        //GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                //.enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                //.addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                //.build();
        
        

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public User getNewUser(){
        System.out.println(newUser);
        return newUser;
    }

    public void newScreen(View view){
        Intent startNewActivity = new Intent(this, WaterActivity.class);
        startNewActivity.putExtra("name", nodot);
        startActivity(startNewActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
}
