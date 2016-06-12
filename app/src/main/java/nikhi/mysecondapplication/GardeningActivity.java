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

public class GardeningActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText edit2;
    double feet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardening);
        Log.i(TAG, "Application is running");

        Button btn1 = (Button)(findViewById(R.id.wateringLawn));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newFeetWash(v);
            }
        });

        edit2 = (EditText) (findViewById(R.id.editText2));

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
        feet = Double.parseDouble(edit2.getText().toString());
    }



    public void newScreen (View view)
    {
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startActivity(startNewActivity);
    }
}
