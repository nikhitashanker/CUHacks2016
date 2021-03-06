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
import android.widget.TextView;

public class WaterDisplayActivity extends Activity {
    static String TAG = "Dashboard Activity";
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Log.i(TAG, "Application is running");

        Button btn1 = (Button)(findViewById(R.id.buttonGallonUsed));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newDisplayScreen(v);
            }
        });

        text = (TextView)(findViewById(R.id.textView2));

        Button btn3 = (Button)(findViewById(R.id.buttonDashboard));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newDashboardScreen(v);
            }
        });



    }


    public void newDisplayScreen (View view)
    {
        text.setVisibility(TextView.VISIBLE);
    }

    public void newDashboardScreen (View view)
    {
        Intent startNewActivity = new Intent (this, DashboardActivity.class);
        startActivity(startNewActivity);
    }


}