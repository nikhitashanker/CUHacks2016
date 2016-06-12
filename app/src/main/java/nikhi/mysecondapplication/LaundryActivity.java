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
import android.widget.EditText;

public class LaundryActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText edit2;
    int load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);
        Log.i(TAG, "Application is running");

        Button btn1 = (Button)(findViewById(R.id.laundry));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newLoad(v);
            }
        });

        edit2 = (EditText) (findViewById(R.id.editTextLaundry));

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
        edit2.setVisibility(EditText.VISIBLE);
        load = Integer.parseInt(edit2.getText().toString());
    }



    public void newScreen (View view)
    {
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startActivity(startNewActivity);
    }
}

