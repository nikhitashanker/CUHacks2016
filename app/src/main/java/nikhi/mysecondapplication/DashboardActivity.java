package nikhi.mysecondapplication;

/**
 * Created by nikhi on 6/10/16.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends Activity {
    static String TAG = "Dashboard Activity";
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent i = getIntent();
        value = i.getStringExtra("name");
        Log.i(TAG, "Application is running");



        Button btn2 = (Button)(findViewById(R.id.buttonLogWater));
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newWaterLogScreen(v);
            }
        });

        Button btn3 = (Button)(findViewById(R.id.buttonDashboard));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newWaterLogScreen(v);
            }
        });

        Button btn4 = (Button)(findViewById(R.id.buttonChallenge));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newChallengeScreen(v);
            }
        });

        Button btn5 = (Button)(findViewById(R.id.buttonAccount));
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newUserScreen(v);
            }
        });

    }

    public void newWaterLogScreen(View view){
        Intent startNewActivity = new Intent(this, WaterActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }

    public void newWaterDisplayScreen (View view)
    {
        Intent startNewActivity = new Intent(this,WaterDisplayActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }

    public void newDashboardScreen (View view)
    {
        Intent startNewActivity = new Intent (this, DashboardActivity.class);
        startNewActivity.putExtra("name", value);
        startActivity(startNewActivity);
    }

    public void newChallengeScreen (View view)
    {
        Intent startChallengeActivity = new Intent (this, ChallengeActivity.class);
        startChallengeActivity.putExtra("name", value);
        startActivity(startChallengeActivity);
    }

    public void newUserScreen (View view)
    {
        Intent startUserActivity = new Intent (this, MainActivity.class);
        startUserActivity.putExtra("name", value);
        startActivity(startUserActivity);
    }
}