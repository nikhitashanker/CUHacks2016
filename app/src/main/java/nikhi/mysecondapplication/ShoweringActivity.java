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

public class ShoweringActivity extends Activity {
    static String TAG = "Showering Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showering);
        Log.i(TAG, "Application is running");

        Button btnStart = (Button)(findViewById(R.id.showerbtn));
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newScreen(v);
            }
        });
    }

    public void newScreen(View view){
        Intent startNewActivity = new Intent(this, WaterActivity.class);
        startActivity(startNewActivity);
    }
}

